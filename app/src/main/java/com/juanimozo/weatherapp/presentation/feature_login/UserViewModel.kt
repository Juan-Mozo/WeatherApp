package com.juanimozo.weatherapp.presentation.feature_login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity
import com.juanimozo.weatherapp.domain.location.LocationTracker
import com.juanimozo.weatherapp.domain.model.CityModel
import com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api.CityUseCases
import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database.UserUseCases
import com.juanimozo.weatherapp.navigation.Screens
import com.juanimozo.weatherapp.presentation.feature_login.registration.RegistrationEvents
import com.juanimozo.weatherapp.presentation.feature_login.search_city_screen.CityState
import com.juanimozo.weatherapp.presentation.feature_login.registration.RegistrationState
import com.juanimozo.weatherapp.presentation.feature_login.auth_screen.UserState
import com.juanimozo.weatherapp.presentation.feature_login.auth_screen.UserStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "UserViewModel"

@HiltViewModel
class UserViewModel @Inject constructor(
    private val cityUseCases: CityUseCases,
    private val userUseCases: UserUseCases,
    private val locationTracker: LocationTracker
): ViewModel() {

    private val _registrationState = mutableStateOf(RegistrationState())
    val registrationState: State<RegistrationState> = _registrationState

    private val _cityState = mutableStateOf(CityState())
    val cityState: State<CityState> = _cityState

    private val _accountResult = mutableStateOf(UserState())
    val account: State<UserState> = _accountResult

    init {
        getAccount()
    }

    private var searchJob: Job? = null
    private var accountJob: Job? = null
    private var getAccountJob: Job? = null

    fun searchCityByName(query: String) {
        // Update query
        _cityState.value = cityState.value.copy(
            searchQuery = query
        )
        // Search city with api call
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            Log.e(TAG, "Query = $cityState.value.searchQuery")
            cityUseCases.searchCityByNameUseCase(
                query = cityState.value.searchQuery,
                language = account.value.account!!.language
            ).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _cityState.value = cityState.value.copy(
                            cities = result.data ?: emptyList()
                        )
                    }
                    is Resource.Error -> {
                        Log.e(TAG, "Error while searching cities, ${result.message}")
                    }
                }
            }
        }
    }

    fun searchCityByGeoPosition(navController: NavController) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            locationTracker.getCurrentLocation().let { location ->
                when (location) {
                    is Resource.Success -> {
                        // Api call requires coordinates as a text coma-separated lat/lon pair
                        val newLocation = "${location.data!!.latitude},${location.data.longitude}"
                        // Add location
                        userUseCases.locationUseCase(newLocation)
                        // Search location with api
                        cityUseCases.searchCityByGeoPositionUseCase(
                            location = newLocation,
                            language = account.value.account!!.language)
                            .collectLatest { result ->
                                when (result) {
                                    is Resource.Success -> {
                                        userUseCases.cityUseCase.updateCurrentCity(
                                            model = result.data!!,
                                            userId = 0
                                        )
                                        navController.navigate(Screens.Forecast.route)
                                    }
                                    is Resource.Error -> {
                                        Log.e(TAG, "Error while searching location, ${result.message}")
                                    }
                                }
                            }
                    }
                    is Resource.Error -> {
                        Log.e(TAG, location.message ?: "")
                    }
                }
            }
        }
    }

    /*
    Get user information from the database and check if:
        - Has already signed up
        - Has a current city saved
     */
    private fun getAccount() {
        getAccountJob?.cancel()
        getAccountJob = viewModelScope.launch {
            userUseCases.getAccountUseCase.invoke(0).collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        // Check whether the user is already in the db
                        if (result.data != null) {
                            val loadedAccount = AccountEntity(
                                accountId = result.data.accountId,
                                name = result.data.name,
                                language = result.data.language,
                                metric = result.data.metric,
                                currentCityLocationKey = result.data.currentCityLocationKey,
                                location = result.data.location
                            )
                            // Check whether the user has a city selected
                            if (result.data.currentCityLocationKey != null) {
                                _accountResult.value = account.value.copy(
                                    account = loadedAccount,
                                    userStatus = UserStatus.FullyRegistered()
                                )
                            } else {
                                _accountResult.value = account.value.copy(
                                    account = loadedAccount,
                                    userStatus = UserStatus.RegisteredWithoutCity()
                                )
                            }

                        } else {
                            _accountResult.value = account.value.copy(
                                account = null,
                                userStatus = UserStatus.NotRegistered()
                            )
                        }
                    }
                    is Resource.Error -> {}
                }
            }
        }
    }

    fun createAccount(navController: NavController) {
        accountJob?.cancel()
        accountJob = viewModelScope.launch {
            userUseCases.createAccountUseCase.invoke(
                AccountEntity(
                    accountId = 0,
                    name = registrationState.value.userName,
                    metric = registrationState.value.selectedMetric,
                    language = registrationState.value.selectedLanguage.abbr,
                    currentCityLocationKey = null,
                    location = null
                )
            )
            navController.navigate(Screens.SearchCity.route)
        }
    }

    fun updateCurrentCity(city: CityModel, navController: NavController) {
        accountJob?.cancel()
        accountJob = viewModelScope.launch {
            // Bind selected city with user
            userUseCases.cityUseCase.updateCurrentCity(city, account.value.account!!.accountId)
            // Navigate to Forecast Screen
            navController.navigate(Screens.Forecast.route)
        }
    }

    fun onEvent(event: RegistrationEvents) {
        when (event) {
            is RegistrationEvents.SelectLanguage -> {
                _registrationState.value = registrationState.value.copy(
                    selectedLanguage = event.language
                )
            }
            is RegistrationEvents.UpdateNameField -> {
                if (event.name.isNotBlank()) {
                    _registrationState.value = registrationState.value.copy(
                        userName = event.name
                    )
                } else {
                    // ToDo:: -Auth- *1* / Priority: M
                    // Description: Add "Insert a valid name" snackbar
                }
            }
        }
    }

}
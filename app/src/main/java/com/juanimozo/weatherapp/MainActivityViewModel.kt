package com.juanimozo.weatherapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity
import com.juanimozo.weatherapp.domain.location.LocationTracker
import com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database.UserUseCases
import com.juanimozo.weatherapp.navigation.Screens
import com.juanimozo.weatherapp.presentation.feature_login.TAG
import com.juanimozo.weatherapp.presentation.feature_login.auth_screen.UserState
import com.juanimozo.weatherapp.presentation.feature_login.auth_screen.UserStatus
import com.juanimozo.weatherapp.util.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val userUseCases: UserUseCases,
    private val locationTracker: LocationTracker
): ViewModel() {

    private val _accountResult = mutableStateOf(UserState())
    val account: State<UserState> = _accountResult

    init {
        getAccount()
    }

    private var searchJob: Job? = null
    private var getAccountJob: Job? = null

    fun updateUserLocation() {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            if (account.value.userStatus != UserStatus.NotRegistered()) {
                // Check permissions and gps connectivity
                locationTracker.getCurrentLocation().let { location ->
                    when (location) {
                        is Resource.Success -> {
                            // Api call requires coordinates as a text coma-separated lat/lon pair
                            val newLocation = "${location.data!!.latitude},${location.data.longitude}"
                            // Add location
                            userUseCases.locationUseCase(newLocation)
                        }
                        is Resource.Error -> {
                            Log.e(TAG, location.message ?: "")
                        }
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

}
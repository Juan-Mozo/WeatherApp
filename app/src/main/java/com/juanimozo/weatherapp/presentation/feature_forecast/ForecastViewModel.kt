package com.juanimozo.weatherapp.presentation.feature_forecast

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanimozo.core_util.language.Language
import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.domain.model.AccountModel
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.ForecastUseCases
import com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database.UserUseCases
import com.juanimozo.weatherapp.presentation.feature_forecast.state.ForecastState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "ForecastViewModel"

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val forecastUseCases: ForecastUseCases,
    private val userUseCases: UserUseCases
): ViewModel() {

    private val _forecastState = mutableStateOf(ForecastState())
    val forecastState: State<ForecastState> = _forecastState

    private val _user = mutableStateOf(AccountModel(0, "", Language.English(),true, 0))
    val user: State<AccountModel> = _user

    private var getForecastJob: Job? = null
    private var getUserJob: Job? = null

    init {
        getUserAndForecast()
    }

    private fun getUserAndForecast() {
        getUserJob?.cancel()
        getUserJob = viewModelScope.launch {
            userUseCases.getAccountUseCase.invoke(0).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        if (result.data != null) {
                            val language = Language.stringToLanguage(result.data.language)
                            val metric = result.data.metric
                            val locationKey = result.data.currentCityLocationKey
                            _user.value = user.value.copy(
                                accountId = result.data.accountId,
                                name = result.data.name,
                                language = language,
                                metric = metric,
                                currentCityLocationKey = locationKey!!
                            )
                            // Get forecast information
                            getForecast(language, locationKey, metric)
                        }
                    }
                    is Resource.Error -> {}
                }
            }
        }
    }

    // Call all forecast functions
    private fun getForecast(language: Language, locationKey: Int, metric: Boolean) {
        getForecastJob?.cancel()
        getForecastJob = viewModelScope.launch {
            getWeeklyForecast(language, locationKey, metric)
            getHourlyForecast(locationKey, language, metric)
            getCurrentConditions(locationKey)
        }
    }

    private suspend fun getWeeklyForecast(language: Language, locationKey: Int, metric: Boolean) {
        forecastUseCases.getWeeklyForecastUseCase.invoke(
            locationKey = locationKey, language = language.abbr, metric = metric
        ).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _forecastState.value = forecastState.value.copy(
                        weeklyForecast = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _forecastState.value = forecastState.value.copy(
                        weeklyForecast = result.data ?: emptyList()
                    )
                    Log.e(TAG, "Error while getting WeeklyForecast")
                }
            }
        }
    }

    private suspend fun getHourlyForecast(locationKey: Int, language: Language, metric: Boolean) {
        forecastUseCases.getHourlyForecastUseCase.invoke(
            locationKey = locationKey, language = language.abbr, metric = metric
        ).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _forecastState.value = forecastState.value.copy(
                        hourlyForecast = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _forecastState.value = forecastState.value.copy(
                        hourlyForecast = result.data ?: emptyList()
                    )
                    Log.e(TAG, "Error while getting HourlyForecast")
                }
            }
        }
    }

    private suspend fun getCurrentConditions(locationKey: Int) {
        forecastUseCases.getCurrentConditionsUseCase.invoke(
            locationKey = locationKey
        ).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _forecastState.value = forecastState.value.copy(
                        currentCondition = result.data,
                        isContentLoaded = true
                    )
                }
                is Resource.Error -> {
                    _forecastState.value = forecastState.value.copy(
                        currentCondition = result.data,
                        isContentLoaded = true
                    )
                    Log.e(TAG, "Error while getting CurrentConditions")
                }
            }
        }
    }
}
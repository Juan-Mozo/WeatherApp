package com.juanimozo.weatherapp.presentation.feature_forecast.state

import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.domain.model.DailyForecastModel
import com.juanimozo.weatherapp.domain.model.HourlyForecastModel

data class ForecastState(
    val currentCondition: CurrentConditionsModel? = null,
    val hourlyForecast: List<HourlyForecastModel> = emptyList(),
    val weeklyForecast: List<DailyForecastModel> = emptyList(),
    val currentCityName: String = "",
    val isContentLoaded: Boolean = false
)

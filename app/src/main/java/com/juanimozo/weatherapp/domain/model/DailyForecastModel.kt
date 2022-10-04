package com.juanimozo.weatherapp.domain.model

import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.Day
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.Night
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.Temperature

data class DailyForecastModel(
    val date: String,
    val day: Day,
    val night: Night,
    val temperature: Temperature
)

package com.juanimozo.weatherapp.domain.model

import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.Day
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.Night
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.Temperature

data class DailyForecastModel(
    val Date: String,
    val Day: Day,
    val Night: Night,
    val Temperature: Temperature
)

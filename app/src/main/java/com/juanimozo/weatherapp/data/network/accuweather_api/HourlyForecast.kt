package com.juanimozo.weatherapp.data.network.accuweather_api

import com.juanimozo.weatherapp.data.network.accuweather_api.hourly_forecast.HourlyForecastItem

data class HourlyForecast(
    val HourlyForecast: List<HourlyForecastItem>
)

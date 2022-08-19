package com.juanimozo.weatherapp.data.network.accuweather_api

import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.DailyForecast
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.Headline

data class WeeklyForecast(
    val DailyForecasts: List<DailyForecast>,
    val Headline: Headline
)
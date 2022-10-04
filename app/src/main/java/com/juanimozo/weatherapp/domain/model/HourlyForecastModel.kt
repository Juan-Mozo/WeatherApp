package com.juanimozo.weatherapp.domain.model

import com.juanimozo.weatherapp.data.network.accuweather_api.hourly_forecast.Temperature

data class HourlyForecastModel(
    val dateTime: String,
    val hasPrecipitation: Boolean,
    val iconPhrase: String,
    val isDaylight: Boolean,
    val precipitationIntensity: String?,
    val precipitationProbability: Int,
    val precipitationType: String?,
    val temperature: Temperature,
    val weatherIcon: Int
)

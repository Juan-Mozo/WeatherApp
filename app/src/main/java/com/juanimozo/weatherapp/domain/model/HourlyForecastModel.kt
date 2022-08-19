package com.juanimozo.weatherapp.domain.model

import com.juanimozo.weatherapp.data.network.accuweather_api.hourly_forecast.Temperature

data class HourlyForecastModel(
    val DateTime: String,
    val HasPrecipitation: Boolean,
    val IconPhrase: String,
    val IsDaylight: Boolean,
    val PrecipitationIntensity: String,
    val PrecipitationProbability: Int,
    val PrecipitationType: String,
    val Temperature: Temperature,
)

package com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast

data class Day(
    val HasPrecipitation: Boolean,
    val Icon: Int,
    val IconPhrase: String,
    val PrecipitationIntensity: String,
    val PrecipitationType: String
)
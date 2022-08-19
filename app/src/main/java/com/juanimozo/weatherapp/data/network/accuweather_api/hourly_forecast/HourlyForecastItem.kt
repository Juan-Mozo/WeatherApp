package com.juanimozo.weatherapp.data.network.accuweather_api.hourly_forecast

data class HourlyForecastItem(
    val DateTime: String,
    val EpochDateTime: Int,
    val HasPrecipitation: Boolean,
    val IconPhrase: String,
    val IsDaylight: Boolean,
    val Link: String,
    val MobileLink: String,
    val PrecipitationIntensity: String,
    val PrecipitationProbability: Int,
    val PrecipitationType: String,
    val Temperature: Temperature,
    val WeatherIcon: Int
)
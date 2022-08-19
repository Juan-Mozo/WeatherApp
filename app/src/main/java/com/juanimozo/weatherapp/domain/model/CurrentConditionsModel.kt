package com.juanimozo.weatherapp.domain.model

import com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions.*

data class CurrentConditionsModel(
    val CloudCover: Int,
    val HasPrecipitation: Boolean,
    val IsDayTime: Boolean,
    val Precip1hr: Precip1hr,
    val Pressure: Pressure,
    val RealFeelTemperature: RealFeelTemperature,
    val RelativeHumidity: Int,
    val Temperature: Temperature,
    val UVIndex: Int,
    val Wind: Wind,
)

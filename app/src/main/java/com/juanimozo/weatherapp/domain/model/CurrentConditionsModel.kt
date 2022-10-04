package com.juanimozo.weatherapp.domain.model

import com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions.*

data class CurrentConditionsModel(
    val cloudCover: Int,
    val hasPrecipitation: Boolean,
    val isDayTime: Boolean,
    val precip1hr: Precip1hr,
    val pressure: Pressure,
    val realFeelTemperature: RealFeelTemperature,
    val relativeHumidity: Int,
    val temperature: Temperature,
    val uVIndex: Int,
    val wind: Wind,
    val weatherIcon: Int,
)

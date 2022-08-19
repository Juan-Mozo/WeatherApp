package com.juanimozo.weatherapp.data.network.accuweather_api.hourly_forecast

data class Temperature(
    val Unit: String,
    val UnitType: Int,
    val Value: Double
)
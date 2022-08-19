package com.juanimozo.weatherapp.data.network.accuweather_api.geolocation

data class TimeZone(
    val Code: String,
    val GmtOffset: Int,
    val IsDaylightSaving: Boolean,
    val Name: String,
    val NextOffsetChange: Any
)
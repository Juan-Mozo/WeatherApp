package com.juanimozo.weatherapp.data.network.accuweather_api.city_search

data class TimeZone(
    val Code: String,
    val GmtOffset: Int,
    val IsDaylightSaving: Boolean,
    val Name: String,
    val NextOffsetChange: String
)
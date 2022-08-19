package com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions


data class TemperatureSummary(
    val Past12HourRange: Past12HourRange,
    val Past24HourRange: Past24HourRange,
    val Past6HourRange: Past6HourRange
)
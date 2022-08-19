package com.juanimozo.weatherapp.data.network.accuweather_api.geolocation

import com.juanimozo.weatherapp.data.network.accuweather_api.geolocation.Elevation

data class GeoPosition(
    val Elevation: Elevation,
    val Latitude: Double,
    val Longitude: Double
)
package com.juanimozo.weatherapp.presentation.feature_login.search_city_screen

import com.juanimozo.weatherapp.domain.model.CityModel

data class CityState(
    var searchQuery: String = "",
    val cities: List<CityModel> = emptyList()
)

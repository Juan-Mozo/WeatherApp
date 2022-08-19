package com.juanimozo.weatherapp.domain.model

import com.juanimozo.weatherapp.data.network.accuweather_api.city_search.Country

data class CitySearchModel(
    val Country: Country,
    val Name: String,
    val Key: String,
)

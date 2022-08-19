package com.juanimozo.weatherapp.data.network.accuweather_api.city_search

data class AdministrativeArea(
    val CountryID: String,
    val EnglishName: String,
    val EnglishType: String,
    val ID: String,
    val Level: Int,
    val LocalizedName: String,
    val LocalizedType: String
)
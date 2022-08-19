package com.juanimozo.weatherapp.data.network.accuweather_api.city_search

data class CitySearchItem(
    val AdministrativeArea: AdministrativeArea,
    val Country: Country,
    val DataSets: List<String>,
    val EnglishName: String,
    val GeoPosition: GeoPositionX,
    val IsAlias: Boolean,
    val Key: String,
    val LocalizedName: String,
    val PrimaryPostalCode: String,
    val Rank: Int,
    val Region: Region,
    val SupplementalAdminAreas: List<SupplementalAdminArea>,
    val TimeZone: TimeZone,
    val Type: String,
    val Version: Int
)
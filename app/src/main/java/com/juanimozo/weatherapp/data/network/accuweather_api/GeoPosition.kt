package com.juanimozo.weatherapp.data.network.accuweather_api

import com.juanimozo.weatherapp.data.network.accuweather_api.city_search.AdministrativeArea
import com.juanimozo.weatherapp.data.network.accuweather_api.city_search.Country
import com.juanimozo.weatherapp.data.network.accuweather_api.city_search.Region
import com.juanimozo.weatherapp.data.network.accuweather_api.city_search.SupplementalAdminArea
import com.juanimozo.weatherapp.data.network.accuweather_api.city_search.TimeZone
import com.juanimozo.weatherapp.data.network.accuweather_api.geolocation.*
import com.juanimozo.weatherapp.data.network.accuweather_api.geolocation.GeoPosition

data class GeoPosition(
    val AdministrativeArea: AdministrativeArea,
    val Country: Country,
    val DataSets: List<String>,
    val EnglishName: String,
    val GeoPosition: GeoPosition,
    val IsAlias: Boolean,
    val Key: String,
    val LocalizedName: String,
    val ParentCity: ParentCity,
    val PrimaryPostalCode: String,
    val Rank: Int,
    val Region: Region,
    val SupplementalAdminAreas: List<SupplementalAdminArea>,
    val TimeZone: TimeZone,
    val Type: String,
    val Version: Int
)
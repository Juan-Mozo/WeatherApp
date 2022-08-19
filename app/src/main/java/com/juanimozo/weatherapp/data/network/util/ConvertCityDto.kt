package com.juanimozo.weatherapp.data.network.util

import com.juanimozo.weatherapp.data.network.accuweather_api.GeoPosition
import com.juanimozo.weatherapp.data.network.accuweather_api.city_search.CitySearchItem
import com.juanimozo.weatherapp.domain.model.CityModel

class ConvertCityDto {

    object ToCityModel {

        fun fromSearchCity(dto: List<CitySearchItem>): List<CityModel>? {
            // Create a new list with the model
            val newList: MutableList<CityModel>? = null
            // Convert each HourlyForecastItem to the model and add it to the list
            for (i in dto) {
                newList?.add(
                    CityModel(
                        Key = i.Key,
                        LocalizedName = i.LocalizedName
                    )
                )
            }
            return newList
        }

        fun fromGeoPosition(dto: GeoPosition): CityModel? {
            return CityModel(
                Key = dto.Key,
                LocalizedName = dto.LocalizedName
            )
        }
    }
}
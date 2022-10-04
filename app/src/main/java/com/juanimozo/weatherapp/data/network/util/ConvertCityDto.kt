package com.juanimozo.weatherapp.data.network.util

import com.juanimozo.weatherapp.data.network.accuweather_api.GeoPosition
import com.juanimozo.weatherapp.data.network.accuweather_api.city_search.CitySearchItem
import com.juanimozo.weatherapp.domain.model.CityModel

class ConvertCityDto {

    object ToCityModel {

        fun fromSearchCity(dto: List<CitySearchItem>): List<CityModel> {
            // Create a new list with the model
            val convertedCity = dto.map { city ->
                CityModel(
                    Key = city.Key,
                    LocalizedName = city.LocalizedName
                )
            }

            return convertedCity
        }

        fun fromGeoPosition(dto: GeoPosition): CityModel {
            return CityModel(
                Key = dto.Key,
                LocalizedName = dto.LocalizedName
            )
        }
    }
}
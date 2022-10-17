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
                    key = city.Key,
                    localizedName = city.LocalizedName,
                    countryLocalizedName = city.Country.LocalizedName,
                    regionLocalizedName = city.Region.LocalizedName
                )
            }

            return convertedCity
        }

        fun fromGeoPosition(dto: GeoPosition): CityModel {
            return CityModel(
                key = dto.Key,
                localizedName = dto.LocalizedName,
                countryLocalizedName = dto.Country.LocalizedName,
                regionLocalizedName = dto.Region.LocalizedName
            )
        }
    }
}
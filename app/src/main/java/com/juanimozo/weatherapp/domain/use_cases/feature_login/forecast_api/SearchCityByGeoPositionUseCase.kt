package com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api

import com.juanimozo.weatherapp.domain.location.LocationTracker
import com.juanimozo.weatherapp.domain.model.CityModel
import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import com.juanimozo.weatherapp.util.resource.Resource
import kotlinx.coroutines.flow.Flow

class SearchCityByGeoPositionUseCase(
    private val repository: ForecastApiRepository
) {
    operator fun invoke(query: String, language: String): Flow<Resource<CityModel>> {
        return repository.searchCityByGeoPosition(query, language)
    }
}
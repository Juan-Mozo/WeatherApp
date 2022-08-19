package com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api

import com.juanimozo.weatherapp.domain.model.CityModel
import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import com.juanimozo.weatherapp.util.resource.Resource
import kotlinx.coroutines.flow.Flow

class SearchCityByNameUseCase(
    private val repository: ForecastApiRepository
) {
    operator fun invoke(query: String, language: String): Flow<Resource<List<CityModel>>> {
        return repository.searchCityByName(query, language)
    }
}
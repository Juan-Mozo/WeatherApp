package com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast

import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentConditionsUseCase(
    private val repository: ForecastApiRepository
) {
    operator fun invoke(locationKey: Int): Flow<Resource<CurrentConditionsModel>> {
        return repository.getCurrentConditions(locationKey)
    }
}
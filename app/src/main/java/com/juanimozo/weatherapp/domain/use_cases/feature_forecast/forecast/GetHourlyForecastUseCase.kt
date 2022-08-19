package com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast

import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.domain.model.HourlyForecastModel
import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import kotlinx.coroutines.flow.Flow

class GetHourlyForecastUseCase(
    private val repository: ForecastApiRepository
) {
    operator fun invoke(locationKey: Int, language: String, metric: Boolean): Flow<Resource<List<HourlyForecastModel>>> {
        return repository.getHourlyForecast(locationKey, language , metric)
    }
}
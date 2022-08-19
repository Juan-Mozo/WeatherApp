package com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast

import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.domain.model.DailyForecastModel
import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import kotlinx.coroutines.flow.Flow

class GetWeeklyForecastUseCase(
    private val repository: ForecastApiRepository
) {
    operator fun invoke(locationKey: Int, language: String, metric: Boolean): Flow<Resource<List<DailyForecastModel>>> {
        return repository.getWeeklyForecast(locationKey, language, metric)
    }
}
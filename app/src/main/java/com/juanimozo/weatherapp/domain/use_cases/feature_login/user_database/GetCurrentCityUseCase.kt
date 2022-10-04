package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

import com.juanimozo.weatherapp.data.database.forecast.entity.CityEntity
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import com.juanimozo.weatherapp.util.resource.Resource
import kotlinx.coroutines.flow.Flow

class GetCurrentCityUseCase(
    private val repository: UserDatabaseRepository
) {
    operator fun invoke(id: Int): Flow<Resource<CityEntity>> {
        return repository.getCurrentCity(id)
    }
}
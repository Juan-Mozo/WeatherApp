package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

import com.juanimozo.weatherapp.data.database.forecast.entity.CityEntity
import com.juanimozo.weatherapp.domain.model.CityModel
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository

class CityUseCase(
    private val repository: UserDatabaseRepository
) {
    suspend fun deleteCity(model: CityModel) {
        val city = cityModelToCityEntity(model)
        repository.deleteCity(city)
    }

    suspend fun updateCurrentCity(model: CityModel, userId: Int) {
        val city = cityModelToCityEntity(model)
        repository.addCity(city)

        repository.updateCurrentCity(model.key.toInt(), userId)
    }

    private fun cityModelToCityEntity(cityModel: CityModel): CityEntity {
        return CityEntity(
            locationKey = cityModel.key,
            name = cityModel.localizedName,
            accountId = 0
        )
    }
}
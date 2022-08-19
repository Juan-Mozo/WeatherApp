package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

import com.juanimozo.weatherapp.data.database.forecast.entity.CityEntity
import com.juanimozo.weatherapp.domain.model.CityModel
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository

class CityUseCase(
    private val repository: UserDatabaseRepository
) {
    suspend fun addCity(model: CityModel) {
        val city = cityModelToCityEntity(model)
        repository.addCity(city)
    }

    suspend fun deleteCity(model: CityModel) {
        val city = cityModelToCityEntity(model)
        repository.deleteCity(city)
    }

    suspend fun updateCurrentCity(model: CityModel, userId: Int) {
        repository.updateCurrentCity(model.Key.toInt(), userId)
    }

    private fun cityModelToCityEntity(cityModel: CityModel): CityEntity {
        return CityEntity(
            locationKey = cityModel.Key,
            name = cityModel.LocalizedName,
            accountId = 0
        )
    }
}
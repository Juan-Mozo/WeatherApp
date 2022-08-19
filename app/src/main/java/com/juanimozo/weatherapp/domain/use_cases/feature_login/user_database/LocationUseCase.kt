package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository

class LocationUseCase(
    private val repository: UserDatabaseRepository
) {
    suspend operator fun invoke(location: String?) {
        repository.updateLocation(location)
    }
}
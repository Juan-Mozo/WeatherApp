package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import com.juanimozo.weatherapp.util.unit.Unit

class UpdateUnitUseCase(
    private val repository: UserDatabaseRepository
) {
    suspend operator fun invoke(unit: Unit, id: Int) {
        return repository.updateUnit(unit, id)
    }
}
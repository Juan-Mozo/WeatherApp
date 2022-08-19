package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository

class CreateAccountUseCase(
    private val repository: UserDatabaseRepository
) {
    suspend operator fun invoke(account: AccountEntity) {
        repository.createAccount(account)
    }
}
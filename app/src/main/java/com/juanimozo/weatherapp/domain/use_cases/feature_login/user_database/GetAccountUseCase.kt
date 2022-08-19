package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity
import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import kotlinx.coroutines.flow.Flow

class GetAccountUseCase(
    private val repository: UserDatabaseRepository
) {
    operator fun invoke(id: Int): Flow<Resource<AccountEntity?>> {
        return repository.getAccountById(id)
    }
}
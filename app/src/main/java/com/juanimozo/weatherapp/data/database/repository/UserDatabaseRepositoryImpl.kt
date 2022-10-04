package com.juanimozo.weatherapp.data.database.repository

import com.juanimozo.weatherapp.data.database.forecast.ForecastDao
import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity
import com.juanimozo.weatherapp.data.database.forecast.entity.CityEntity
import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import com.juanimozo.weatherapp.util.language.Language
import com.juanimozo.weatherapp.util.unit.Unit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserDatabaseRepositoryImpl(
    private val db: ForecastDao
): UserDatabaseRepository {

    override suspend fun createAccount(account: AccountEntity) {
        db.insertAccount(account)
    }

    override suspend fun deleteAccount(id: Int) {
        db.deleteAccount(id)
    }

    override suspend fun addCity(city: CityEntity) {
        db.insertCity(city)
    }

    override suspend fun deleteCity(city: CityEntity) {
        db.deleteCity(city)
    }

    override suspend fun updateCurrentCity(cityKey: Int, id: Int) {
        db.updateCurrentCity(cityKey, id)
    }

    override suspend fun updateLanguage(language: Language, id: Int) {
        db.updateLanguage(language.abbr, id)
    }

    override suspend fun updateUnit(unit: Unit, id: Int) {
        db.updateUnit(unit.isMetric, id)
    }

    override suspend fun updateLocation(location: String?) {
        if (location != null) {
            db.updateLocation(location)
        }
    }

    override fun getAccountById(id: Int): Flow<Resource<AccountEntity?>> = flow {
        val account = db.getAccount(id)
        if (account == null) {
            emit(Resource.Success(data = null))
        } else {
            emit(Resource.Success(data = account))
        }
    }

    override fun getCurrentCity(id: Int): Flow<Resource<CityEntity>> = flow {
        val currentCity = db.getCurrentCity(id)
        emit(Resource.Success(data = currentCity))
    }

    override fun getCitiesByAccountId(id: Int): Flow<Resource<List<CityEntity>>> = flow {
        val cities = db.getCities()
        emit(Resource.Success(data = cities))
    }
}
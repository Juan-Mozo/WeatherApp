package com.juanimozo.weatherapp.domain.repository

import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity
import com.juanimozo.weatherapp.data.database.forecast.entity.CityEntity
import com.juanimozo.weatherapp.util.language.Language
import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.util.unit.Unit
import kotlinx.coroutines.flow.Flow

interface UserDatabaseRepository {

    suspend fun createAccount(account: AccountEntity)

    suspend fun deleteAccount(id: Int)

    suspend fun addCity(city: CityEntity)

    suspend fun deleteCity(city: CityEntity)

    suspend fun updateCurrentCity(cityKey: Int, id: Int)

    suspend fun updateLocation(location: String?)

    suspend fun updateLanguage(language: Language, id: Int)

    suspend fun updateUnit(unit: Unit, id: Int)

    fun getAccountById(id: Int): Flow<Resource<AccountEntity?>>

    fun getCurrentCity(id: Int): Flow<Resource<CityEntity>>

    fun getCitiesByAccountId(id: Int): Flow<Resource<List<CityEntity>>>

}
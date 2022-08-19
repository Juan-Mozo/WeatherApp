package com.juanimozo.weatherapp.data.database.forecast

import androidx.room.*
import com.juanimozo.weatherapp.data.database.forecast.entity.CityEntity
import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity

@Dao
interface ForecastDao {

    // Insert new account
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: AccountEntity)

    // Insert new city
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: CityEntity)

    // Delete city
    @Delete
    suspend fun deleteCity(city: CityEntity)

    // Update current city
    @Query("UPDATE account SET currentCityLocationKey = :newCityKey WHERE accountId = :accountId")
    suspend fun updateCurrentCity(newCityKey: Int, accountId: Int)

    // Update coordinates location
    @Query("UPDATE account SET location = :location WHERE accountId = 0 ")
    suspend fun updateLocation(location: String)

    @Query("SELECT * FROM city " +
            "WHERE city.locationKey = " +
            "(SELECT currentCityLocationKey FROM account WHERE accountId = :accountId)")
    suspend fun getCurrentCity(accountId: Int): CityEntity

    @Query("SELECT * FROM city")
    suspend fun getCities(): List<CityEntity>

    // Return first account
    @Query("SELECT * FROM account WHERE accountId = :id")
    suspend fun getAccount(id: Int): AccountEntity?
}
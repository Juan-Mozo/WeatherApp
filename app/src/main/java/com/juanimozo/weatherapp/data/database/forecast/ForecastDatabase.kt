package com.juanimozo.weatherapp.data.database.forecast

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juanimozo.weatherapp.data.database.forecast.entity.CityEntity
import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity

@Database(
    entities = [
        AccountEntity::class,
        CityEntity::class
               ],
    version = 1,
    exportSchema = false
)
abstract class ForecastDatabase: RoomDatabase() {
    abstract val dao: ForecastDao
}
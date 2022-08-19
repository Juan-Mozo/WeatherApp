package com.juanimozo.weatherapp.data.database.forecast.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class CityEntity(
    @PrimaryKey val locationKey: String,
    val name: String,
    val accountId: Int
)

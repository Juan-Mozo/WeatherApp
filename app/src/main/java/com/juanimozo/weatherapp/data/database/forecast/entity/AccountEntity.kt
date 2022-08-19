package com.juanimozo.weatherapp.data.database.forecast.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.juanimozo.core_util.language.Language

@Entity(tableName = "account")
data class AccountEntity(
    @PrimaryKey(autoGenerate = false) val accountId: Int,
    val name: String,
    val language: String,
    val metric: Boolean,
    val currentCityLocationKey: Int?,
    // Coordinates (lat,lon)
    val location: String?
)

package com.juanimozo.weatherapp.di

import android.app.Application
import androidx.room.Room
import com.juanimozo.weatherapp.data.database.forecast.ForecastDatabase
import com.juanimozo.weatherapp.data.database.repository.UserDatabaseRepositoryImpl
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object DatabaseModule {
//
//    @Provides
//    @Singleton
//    fun provideForecastDatabase(app: Application): ForecastDatabase {
//        return Room.databaseBuilder(
//            app, ForecastDatabase::class.java, "forecast.db"
//        )
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideForecastDatabaseRepository(
//        db: ForecastDatabase
//    ): UserDatabaseRepository {
//        return UserDatabaseRepositoryImpl(db.dao)
//    }
//
//}
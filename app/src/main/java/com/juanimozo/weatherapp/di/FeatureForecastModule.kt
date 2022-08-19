package com.juanimozo.weatherapp.di

import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.ForecastUseCases
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.GetCurrentConditionsUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.GetHourlyForecastUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.GetWeeklyForecastUseCase
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object FeatureForecastModule {
//
//    // ForecastUseCases
//    @Provides
//    @Singleton
//    fun provideForecastUseCases(repository: ForecastApiRepository): ForecastUseCases {
//        return ForecastUseCases(
//            getCurrentConditionsUseCase = GetCurrentConditionsUseCase(repository),
//            getHourlyForecastUseCase = GetHourlyForecastUseCase(repository),
//            getWeeklyForecastUseCase = GetWeeklyForecastUseCase(repository)
//        )
//    }
//
//    @Provides
//    @Singleton
//    fun provideUserUseCases(repository: UserDatabaseRepository): UserUseCases {
//        return UserUseCases(
//            getAccountUseCase = GetAccountUseCase(repository)
//        )
//    }
//
//}
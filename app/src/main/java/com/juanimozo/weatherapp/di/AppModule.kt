package com.juanimozo.weatherapp.di

import android.app.Application
import androidx.room.Room
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.juanimozo.weatherapp.data.network.repository.ForecastApiRepositoryImpl
import com.juanimozo.weatherapp.data.database.forecast.ForecastDatabase
import com.juanimozo.weatherapp.data.database.repository.UserDatabaseRepositoryImpl
import com.juanimozo.weatherapp.data.location.DefaultLocationTracker
import com.juanimozo.weatherapp.data.network.AccuWeatherApi
import com.juanimozo.weatherapp.domain.location.LocationTracker
import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.ForecastUseCases
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.GetCurrentConditionsUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.GetHourlyForecastUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast.GetWeeklyForecastUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api.CityUseCases
import com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api.SearchCityByGeoPositionUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api.SearchCityByNameUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // AccuWeather Api
    @Singleton
    @Provides
    fun provideAccuWeatherApi(): AccuWeatherApi {
        return Retrofit.Builder()
            .baseUrl(AccuWeatherApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AccuWeatherApi::class.java)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Singleton
    @Provides
    fun provideLocationTracker(app: Application): LocationTracker {
        return DefaultLocationTracker(
            application = app,
            locationClient = LocationServices.getFusedLocationProviderClient(app)
        )
    }

    // ForecastApiRepository
    @Provides
    @Singleton
    fun provideForecastRepository(api: AccuWeatherApi): ForecastApiRepository {
        return ForecastApiRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideForecastDatabase(app: Application): ForecastDatabase {
        return Room.databaseBuilder(
            app, ForecastDatabase::class.java, "forecast.db"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideForecastDatabaseRepository(
        db: ForecastDatabase
    ): UserDatabaseRepository {
        return UserDatabaseRepositoryImpl(db.dao)
    }

    // ForecastUseCases
    @Provides
    @Singleton
    fun provideForecastUseCases(repository: ForecastApiRepository): ForecastUseCases {
        return ForecastUseCases(
            getCurrentConditionsUseCase = GetCurrentConditionsUseCase(repository),
            getHourlyForecastUseCase = GetHourlyForecastUseCase(repository),
            getWeeklyForecastUseCase = GetWeeklyForecastUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideCityUseCases(repository: ForecastApiRepository): CityUseCases {
        return CityUseCases(
            searchCityByGeoPositionUseCase = SearchCityByGeoPositionUseCase(repository),
            searchCityByNameUseCase = SearchCityByNameUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideUsersUseCases(repository: UserDatabaseRepository): UserUseCases {
        return UserUseCases(
            createAccountUseCase = CreateAccountUseCase(repository),
            getAccountUseCase = GetAccountUseCase(repository),
            cityUseCase = CityUseCase(repository),
            locationUseCase = LocationUseCase(repository)
        )
    }

}
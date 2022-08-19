package com.juanimozo.weatherapp.di

import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api.SearchCityByGeoPositionUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api.SearchCityByNameUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database.CityUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database.CreateAccountUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database.GetAccountUseCase
import com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database.UserUseCases
import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object FeatureLoginModule {
//
////    @Provides
////    @Singleton
////    fun provideLoginUseCases(repository: AuthRepository): FirebaseUseCases {
////        return FirebaseUseCases(
////            isUserAuthenticatedUseCase = IsUserAuthenticatedUseCase(repository),
////            getAuthStateUseCase = GetAuthStateUseCase(repository),
////            signInAnonymouslyUseCase = SignInAnonymouslyUseCase(repository),
////            signOutUseCase = SignOutUseCase(repository)
////        )
////    }
//
//    @Provides
//    @Singleton
//    fun provideForecastUseCases(repository: ForecastApiRepository): ForecastUseCases {
//        return ForecastUseCases(
//            searchCityByGeoPositionUseCase = SearchCityByGeoPositionUseCase(repository),
//            searchCityByNameUseCase = SearchCityByNameUseCase(repository)
//        )
//    }
//
//    @Provides
//    @Singleton
//    fun provideUserUseCases(repository: UserDatabaseRepository): UserUseCases {
//        return UserUseCases(
//            createAccountUseCase = CreateAccountUseCase(repository),
//            getAccountUseCase = GetAccountUseCase(repository),
//            cityUseCase = CityUseCase(repository)
//        )
//    }
//
//}
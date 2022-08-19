package com.juanimozo.weatherapp.di

//@Module
//@InstallIn(SingletonComponent::class)
//object CoreNetworkModule {

//    // AccuWeather Api
//    @Singleton
//    @Provides
//    fun provideAccuWeatherApi(): AccuWeatherApi {
//        return Retrofit.Builder()
//            .baseUrl(AccuWeatherApi.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(AccuWeatherApi::class.java)
//    }
//
//    // ForecastApiRepository
//    @Provides
//    @Singleton
//    fun provideForecastRepository(api: AccuWeatherApi): ForecastApiRepository {
//        return ForecastApiRepositoryImpl(api)
//    }
//
//
//
//}
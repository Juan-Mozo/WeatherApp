package com.juanimozo.weatherapp.domain.use_cases.feature_login.forecast_api

data class CityUseCases(
    val searchCityByGeoPositionUseCase: SearchCityByGeoPositionUseCase,
    val searchCityByNameUseCase: SearchCityByNameUseCase
)

package com.juanimozo.weatherapp.domain.use_cases.feature_forecast.forecast

data class ForecastUseCases(
    val getCurrentConditionsUseCase: GetCurrentConditionsUseCase,
    val getWeeklyForecastUseCase: GetWeeklyForecastUseCase,
    val getHourlyForecastUseCase: GetHourlyForecastUseCase
)

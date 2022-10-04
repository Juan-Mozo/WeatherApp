package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

data class UserUseCases(
    val createAccountUseCase: CreateAccountUseCase,
    val getAccountUseCase: GetAccountUseCase,
    val cityUseCase: CityUseCase,
    val locationUseCase: LocationUseCase,
    val getCurrentCityUseCase: GetCurrentCityUseCase,
    val deleteAccountUseCase: DeleteAccountUseCase,
    val updateLanguageUseCase: UpdateLanguageUseCase,
    val updateUnitUseCase: UpdateUnitUseCase
)

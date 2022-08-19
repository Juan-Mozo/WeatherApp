package com.juanimozo.weatherapp.presentation.feature_login.auth_screen

import com.juanimozo.weatherapp.data.database.forecast.entity.AccountEntity

data class UserState(
    val account: AccountEntity? = null,
    val userStatus: UserStatus = UserStatus.NotRegistered()
)

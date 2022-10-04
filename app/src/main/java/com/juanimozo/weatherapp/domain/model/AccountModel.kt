package com.juanimozo.weatherapp.domain.model

import com.juanimozo.weatherapp.util.language.Language

data class AccountModel(
    val accountId: Int,
    val name: String,
    val language: Language,
    val metric: Boolean,
    val currentCityLocationKey: Int
    )

package com.juanimozo.weatherapp.domain.model

import com.juanimozo.core_util.language.Language

data class AccountModel(
    // ToDo:: -Cambiar int de locationKey por String- *1* / Priority: H
    // Description:
    val accountId: Int,
    val name: String,
    val language: Language,
    val metric: Boolean,
    val currentCityLocationKey: Int)

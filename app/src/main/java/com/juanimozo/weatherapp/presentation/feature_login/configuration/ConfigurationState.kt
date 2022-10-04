package com.juanimozo.weatherapp.presentation.feature_login.configuration

import com.juanimozo.weatherapp.util.language.Language
import com.juanimozo.weatherapp.util.unit.Unit

data class ConfigurationState(
    val language: Language = Language.English(),
    val unit: Unit = Unit.Metric()
)

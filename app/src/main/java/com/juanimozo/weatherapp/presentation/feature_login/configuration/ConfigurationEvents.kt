package com.juanimozo.weatherapp.presentation.feature_login.configuration

import com.juanimozo.weatherapp.util.language.Language
import com.juanimozo.weatherapp.util.unit.Unit

sealed class ConfigurationEvents {
    class SelectLanguage(val language: Language): ConfigurationEvents()
    class SelectUnit(val unit: Unit): ConfigurationEvents()
}

package com.juanimozo.weatherapp.presentation.feature_login.registration

import com.juanimozo.weatherapp.util.language.Language

data class RegistrationState(
    val userName: String = "",
    val selectedLanguage: Language = Language.English(),
    val selectedMetric: Boolean = false
)
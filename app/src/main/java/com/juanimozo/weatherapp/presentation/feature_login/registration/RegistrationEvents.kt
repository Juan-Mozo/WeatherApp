package com.juanimozo.weatherapp.presentation.feature_login.registration

import com.juanimozo.core_util.language.Language

sealed class RegistrationEvents {
    data class SelectLanguage(val language: Language): RegistrationEvents()
    data class UpdateNameField(val name: String): RegistrationEvents()
}

package com.juanimozo.weatherapp.presentation.feature_login.registration

import com.juanimozo.weatherapp.util.language.Language

sealed class RegistrationEvents {
    class SelectLanguage(val language: Language): RegistrationEvents()
    class UpdateNameField(val name: String): RegistrationEvents()
}

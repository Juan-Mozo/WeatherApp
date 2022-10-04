package com.juanimozo.weatherapp.domain.use_cases.feature_login.user_database

import com.juanimozo.weatherapp.domain.repository.UserDatabaseRepository
import com.juanimozo.weatherapp.util.language.Language

class UpdateLanguageUseCase(
    private val repository: UserDatabaseRepository
) {
    suspend operator fun invoke(language: Language, id: Int) {
        return repository.updateLanguage(language, id)
    }
}
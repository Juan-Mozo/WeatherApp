package com.juanimozo.core_util.language

sealed class Language(val abbr: String, val translatedName: String) {

    // ToDo:: -Language- *1* / Priority: M
    // Description: Add translated name with string resources

    class English(abbr: String = "en-us", translatedName: String = "English"): Language(abbr, translatedName)
    class Spanish(abbr: String = "es-ar", translatedName: String = "Spanish"): Language(abbr, translatedName)
    class French(abbr: String = "fr-fr", translatedName: String = "French"): Language(abbr, translatedName)
    class German(abbr: String = "de-de", translatedName: String = "German"): Language(abbr, translatedName)

    companion object {

        fun stringToLanguage(abbr: String): Language {
            return when (abbr) {
                "en-us" -> English("en-us")
                "es-ar" -> Spanish("es-ar")
                "fr-fr" -> French("fr-fr")
                "de-de" -> German("de-de")
                else -> English("en-us")
            }
        }

        val languagesList = listOf<Language>(English(), Spanish(), French(), German())
    }
}

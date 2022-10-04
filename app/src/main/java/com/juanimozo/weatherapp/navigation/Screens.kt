package com.juanimozo.weatherapp.navigation

sealed class Screens(val route: String) {
    object Forecast : Screens("forecast")
    object CurrentForecastDetails : Screens("current-forecast")
    object Auth : Screens("auth")
    object SearchCity : Screens("search-city")
    object ManageCities : Screens("manage-cities")
    object SelectLanguage : Screens("select-language")
    object SelectUnits : Screens("select-units")
}

package com.juanimozo.weatherapp.ui.components.navigation_drawer

import com.juanimozo.weatherapp.R
import com.juanimozo.weatherapp.navigation.Screens

sealed class MenuItem(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: Int,
    val route: String
) {

    class Cities() : MenuItem(
        id = "cities",
        title = "Cities",
        contentDescription = "Manage cities",
        icon = R.drawable.cityscape,
        route = Screens.SearchCity.route
    )
    class Language() : MenuItem(
        id = "language",
        title = "Language",
        contentDescription = "Go to language screen",
        icon = R.drawable.language,
        route = Screens.SelectLanguage.route
    )
    class Unit() : MenuItem(
        id = "units",
        title = "Units",
        contentDescription = "Go to units screen",
        icon = R.drawable.measure,
        route = Screens.SelectUnits.route
    )
    class LogOut() : MenuItem(
        id = "logOut",
        title = "Log Out",
        contentDescription = "Log out",
        icon = R.drawable.logout,
        route = Screens.Auth.route
    )

    companion object Items {

        fun getItems(): List<MenuItem> {
            return listOf(Cities(), Language(), Unit(), LogOut())
        }

    }

}

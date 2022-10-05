package com.juanimozo.weatherapp.ui.components.navigation_drawer

import android.content.res.Resources
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
        title = Resources.getSystem().getString(R.string.cities_title),
        contentDescription = "Manage cities",
        icon = R.drawable.cityscape,
        route = Screens.SearchCity.route
    )
    class Language() : MenuItem(
        id = "language",
        title = Resources.getSystem().getString(R.string.language_title),
        contentDescription = "Go to language screen",
        icon = R.drawable.language,
        route = Screens.SelectLanguage.route
    )
    class Unit() : MenuItem(
        id = "units",
        title = Resources.getSystem().getString(R.string.units_title),
        contentDescription = "Go to units screen",
        icon = R.drawable.measure,
        route = Screens.SelectUnits.route
    )
    class LogOut() : MenuItem(
        id = "logOut",
        title = Resources.getSystem().getString(R.string.log_out_title),
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

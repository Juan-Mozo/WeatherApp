package com.juanimozo.weatherapp.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juanimozo.weatherapp.presentation.feature_forecast.current_forecast_details.CurrentForecastDetailsScreen
import com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.ForecastScreen
import com.juanimozo.weatherapp.presentation.feature_login.auth_screen.AuthScreen
import com.juanimozo.weatherapp.presentation.feature_login.search_city_screen.SearchCityScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Auth.route
    ) {

        // Auth
        composable(Screens.Auth.route) {
            AuthScreen(navController = navController)
        }

        // Search City
        composable(Screens.SearchCity.route) {
            SearchCityScreen(navController = navController)
        }

        // Forecast
        composable(Screens.Forecast.route) {
            ForecastScreen(navController = navController)
        }
        // Forecast Details
        composable(Screens.CurrentForecastDetails.route) {
            CurrentForecastDetailsScreen()
        }
    }
}
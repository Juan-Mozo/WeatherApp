package com.juanimozo.weatherapp.presentation.feature_login.auth_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.ForecastScreen
import com.juanimozo.weatherapp.presentation.feature_login.UserViewModel
import com.juanimozo.weatherapp.presentation.feature_login.registration.RegistrationScreen
import com.juanimozo.weatherapp.presentation.feature_login.search_city_screen.SearchCityScreen

@Composable
fun AuthScreen(navController: NavController) {

    val viewModel: UserViewModel = hiltViewModel()

    when (viewModel.account.value.userStatus) {
        is UserStatus.NotRegistered -> {
            RegistrationScreen(navController)
        }
        is UserStatus.RegisteredWithoutCity -> {
            SearchCityScreen(navController)
        }
        is UserStatus.FullyRegistered -> {
            ForecastScreen(navController)
        }
    }

}

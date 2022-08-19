package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.presentation.feature_forecast.ForecastViewModel
import com.juanimozo.feature_forecast.presentation.util.DateTime

@Composable
fun ForecastScreen(
    navController: NavController
) {

    val viewModel: ForecastViewModel = hiltViewModel()
    val forecastState = viewModel.forecastState.value

    Column(modifier = Modifier.fillMaxWidth()) {
        // Time and Day of the week
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = DateTime(DateTime.Format.HourDay).getDateTime()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Card with current temperature
        Row(modifier = Modifier.fillMaxWidth()) {
            CurrentForecastCard(
                currentConditions = forecastState.currentCondition,
                navController = navController
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Row with all hourly forecast
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(forecastState.hourlyForecast) { hourly ->
                HourlyForecastItem(item = hourly)
            }
        }
        Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 4.dp))
        // Column with all daily forecast
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(forecastState.weeklyForecast) { daily ->
                DailyForecastItem(item = daily)
            }
        }
    }
}
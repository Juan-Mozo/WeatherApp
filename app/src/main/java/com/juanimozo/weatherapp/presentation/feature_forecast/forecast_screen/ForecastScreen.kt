package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.presentation.feature_forecast.ForecastViewModel
import com.juanimozo.weatherapp.presentation.feature_forecast.util.DateTime
import com.juanimozo.weatherapp.ui.theme.Values

@Composable
fun ForecastScreen(
    navController: NavController
) {

    val viewModel: ForecastViewModel = hiltViewModel()
    val forecastState = viewModel.forecastState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        // City Name
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            // ToDo:: -1- *ForecastScreen* / Priority: H
            // Description: add getCityName
            Text(
                text = "Buenos Aires",
                style = MaterialTheme.typography.h1
            )
        }

        // Time and Day of the week
        Row(
            modifier = Modifier
                .padding(vertical = Values.Padding.small)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(start = Values.Padding.large),
                text = DateTime(DateTime.Format.HourDay).getDateTime(),
                style = MaterialTheme.typography.subtitle1
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
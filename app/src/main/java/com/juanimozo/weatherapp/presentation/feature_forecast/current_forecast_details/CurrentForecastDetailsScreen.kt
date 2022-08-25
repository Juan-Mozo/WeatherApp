package com.juanimozo.weatherapp.presentation.feature_forecast.current_forecast_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.juanimozo.weatherapp.presentation.feature_forecast.ForecastViewModel
import com.juanimozo.feature_forecast.presentation.util.TemperatureFormat
import com.juanimozo.weatherapp.ui.util.HalfFraction
import com.valentinilk.shimmer.shimmer

@Composable
fun CurrentForecastDetailsScreen() {

    val viewModel: ForecastViewModel = hiltViewModel()
    val currentForecast = viewModel.forecastState.value.currentCondition

    /*
    When forecast information is loaded show then the entire content.
    But if the information is loading show an animated Shimmer Effect
     */
    if (currentForecast != null) {
        // ToDo:: -1- *CurrentForecastDetailsScreen* / Priority: M
        // Description: ADD BANNER
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {

        }

        // Temperature
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = TemperatureFormat.formatDoubleTemperature(
                    temperature = currentForecast.Temperature.Metric.Value,
                    unit = currentForecast.Temperature.Metric.Unit
                ),
                style = MaterialTheme.typography.h1
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Real Feel Temperature
            CurrentForecastDetailsItem(
                title = "Real Feel",
                content = TemperatureFormat.formatDoubleTemperature(
                    temperature = currentForecast.RealFeelTemperature.Metric.Value,
                    unit = currentForecast.RealFeelTemperature.Metric.Unit)
            )
            // Wind Speed
            CurrentForecastDetailsItem(
                title = "Wind Speed",
                content = "${currentForecast.Wind.Speed.Metric.Value.toInt()} km/h")
            // Wind Direction
            CurrentForecastDetailsItem(
                title = "Wind Direction",
                content = currentForecast.Wind.Direction.English)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Humidity
            CurrentForecastDetailsItem(
                title = "Humidity",
                content = "${currentForecast.RelativeHumidity}%")
            // Pressure
            CurrentForecastDetailsItem(
                title = "Pressure",
                content = "${currentForecast.Pressure.Metric.Value.toInt()} mb")
            // Wind Direction
            CurrentForecastDetailsItem(
                title = "UV Index",
                content = currentForecast.UVIndex.toString())
        }
    } else {
        // Loading Animation
    }

}
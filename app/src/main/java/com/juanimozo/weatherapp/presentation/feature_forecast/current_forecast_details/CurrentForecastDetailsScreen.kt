package com.juanimozo.weatherapp.presentation.feature_forecast.current_forecast_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.juanimozo.weatherapp.presentation.feature_forecast.ForecastViewModel
import com.juanimozo.feature_forecast.presentation.util.TemperatureFormat
import com.juanimozo.weatherapp.ui.util.HalfFraction
import com.valentinilk.shimmer.shimmer

@Composable
fun CurrentForecastDetailsScreen() {

    val viewModel: ForecastViewModel = hiltViewModel()
    val currentForecast = viewModel.forecastState.value.currentCondition

    val fraction = HalfFraction

    /*
    When forecast information is loaded show then the entire content.
    But if the information is loading show an animated Shimmer Effect
     */
    if (currentForecast != null) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Current Temperature
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = TemperatureFormat.formatIntTemperature(
                    temperature = currentForecast.Temperature.Metric.Value,
                    unit =currentForecast.Temperature.Metric.Unit)
                )
            }
            Row(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxWidth(fraction)
                    .fillMaxHeight()
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
                Column(modifier = Modifier
                    .fillMaxWidth(fraction)
                    .fillMaxHeight()
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
            }
        }
    } else {
        Column(modifier = Modifier.fillMaxSize().shimmer()) {
            // Current Temperature
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "")
            }
            Row(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxWidth(fraction)
                    .fillMaxHeight()
                ) {
                    (0..2).forEach { _ ->
                        CurrentForecastDetailsItem("", "")
                    }
                }
                Column(modifier = Modifier
                    .fillMaxWidth(fraction)
                    .fillMaxHeight()
                ) {
                    (0..2).forEach { _ ->
                        CurrentForecastDetailsItem("", "")
                    }
                }
            }
        }
    }

}
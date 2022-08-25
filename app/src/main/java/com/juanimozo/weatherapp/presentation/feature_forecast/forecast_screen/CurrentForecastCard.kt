package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanimozo.weatherapp.data.forecast.Forecast
import com.juanimozo.weatherapp.ui.theme.Shapes
import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.navigation.Screens
import com.juanimozo.weatherapp.ui.theme.Values
import com.valentinilk.shimmer.shimmer

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CurrentForecastCard(
    currentConditions: CurrentConditionsModel?,
    navController: NavController
) {

    /*
    When forecast information is loaded show then the entire content.
    But if the information is loading show an animated Shimmer Effect
     */

    if (currentConditions != null) {
        // ToDo:: -ForecastScreen- *1* / Priority: L
        // Description: Change card color if IsDayTime
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = Shapes.medium,
            backgroundColor = MaterialTheme.colors.primary,
            onClick = { navController.navigate(Screens.CurrentForecastDetails.route) }
        ) {
            CurrentForecastCardContent(currentConditions = currentConditions)
        }
    } else {
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .shimmer(),
            shape = Shapes.medium,
            backgroundColor = MaterialTheme.colors.primary,
            onClick = { navController.navigate(Screens.CurrentForecastDetails.route) }
        ) {
            CurrentForecastCardContent(currentConditions = null)
        }
    }
}

@Composable
fun CurrentForecastCardContent(currentConditions: CurrentConditionsModel?) {

    val weather: Forecast.Weather = Forecast().setWeatherWithPrecipitation(
        hasPrecipitation = currentConditions?.HasPrecipitation ?: false,
        isDayTime = currentConditions?.IsDayTime ?: true,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(0.5f)
    ) {
        Row(
            modifier = Modifier
                .padding(Values.Padding.small)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Currently",
                style = MaterialTheme.typography.subtitle1)
        }
        Row(
            modifier = Modifier
                .padding(Values.Padding.small)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            val temperatureText: String = currentConditions?.Temperature?.Metric?.Value.toString() ?: ""
            Text(
                // ToDo:: -ForecastScreen- *3* / Priority: M
                // Description: Format temperature
                text = temperatureText,
                style = MaterialTheme.typography.body1
            )
        }
        Row(
            modifier = Modifier
                .padding(Values.Padding.small)
                .fillMaxWidth()
        ) {
            val realFeelTemperatureText: String = currentConditions?.RealFeelTemperature?.Metric?.Value.toString()
            Text(
                text = "Feels like: $realFeelTemperatureText",
                style = MaterialTheme.typography.body1
            )
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

        }
        Row(modifier = Modifier.fillMaxWidth()) {
            // ToDo:: -ForecastScreen- *4* / Priority: M
            // Description: Format CloudCover and add icons
            val cloudCoverText: String = currentConditions?.CloudCover?.toString() ?: ""
            Text(
                text = cloudCoverText,
                style = MaterialTheme.typography.body1
            )
        }
    }
}
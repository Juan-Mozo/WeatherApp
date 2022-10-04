package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanimozo.feature_forecast.presentation.util.TemperatureFormat
import com.juanimozo.weatherapp.data.forecast.Forecast
import com.juanimozo.weatherapp.ui.theme.Shapes
import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.navigation.Screens
import com.juanimozo.weatherapp.ui.theme.Values
import com.juanimozo.weatherapp.ui.theme.weatherPalette

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
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = Shapes.medium,
            backgroundColor = MaterialTheme.weatherPalette.cardBackground,
            onClick = { navController.navigate(Screens.CurrentForecastDetails.route) }
        ) {
            CurrentForecastCardContent(currentConditions = currentConditions)
        }
    }
}

@Composable
fun CurrentForecastCardContent(currentConditions: CurrentConditionsModel) {

    val weather: Forecast.Weather = Forecast().setWeatherWithIcon(
        iconNumber = currentConditions.weatherIcon
    )

    Column(
        modifier = Modifier
            .padding(vertical = Values.Padding.medium, horizontal = Values.Padding.small)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Currently",
                style = MaterialTheme.typography.subtitle1
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(horizontal = Values.Padding.medium),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(75.dp),
                    painter = painterResource(id = weather.icon),
                    contentDescription = weather.text
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = TemperatureFormat.formatDoubleTemperature(
                        temperature = currentConditions.temperature.Metric.Value,
                        unit = currentConditions.temperature.Metric.Unit
                    ),
                    style = MaterialTheme.typography.h1
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                val formattedTemperature = TemperatureFormat.formatDoubleTemperature(
                    temperature = currentConditions.realFeelTemperature.Metric.Value,
                    unit = currentConditions.realFeelTemperature.Metric.Unit
                )
                Text(
                    text = "Feels like: $formattedTemperature",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}
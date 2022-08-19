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
import com.juanimozo.weatherapp.ui.theme.Shapes
import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.navigation.Screens
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
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.3f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // ToDo:: -ForecastScreen- *2* / Priority: M
                    // Description: Add Icons
                    Icon(
                        modifier = Modifier.padding(4.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star"
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.3f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        // ToDo:: -ForecastScreen- *3* / Priority: M
                        // Description: Format temperature
                        text = currentConditions.Temperature.toString()
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.3f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        // ToDo:: -ForecastScreen- *4* / Priority: M
                        // Description: Format CloudCover and add icons
                        Text(text = currentConditions.CloudCover.toString())
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Feels like: $currentConditions.RealFeelTemperature")
                    }
                }
            }
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
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.3f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.padding(4.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star"
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.3f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "")
                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.3f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "")
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "")
                    }
                }
            }
        }
    }
}
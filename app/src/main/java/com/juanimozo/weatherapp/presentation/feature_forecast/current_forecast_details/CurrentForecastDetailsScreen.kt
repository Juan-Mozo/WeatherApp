package com.juanimozo.weatherapp.presentation.feature_forecast.current_forecast_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.juanimozo.weatherapp.presentation.feature_forecast.ForecastViewModel
import com.juanimozo.feature_forecast.presentation.util.TemperatureFormat
import com.juanimozo.weatherapp.presentation.feature_forecast.animations.LoadingAnimation
import com.juanimozo.weatherapp.ui.theme.DarkGreyTeal
import com.juanimozo.weatherapp.ui.theme.Fonts
import com.juanimozo.weatherapp.R
import com.juanimozo.weatherapp.ui.components.navigation_drawer.AppBar
import com.juanimozo.weatherapp.ui.components.navigation_drawer.DrawerBody
import com.juanimozo.weatherapp.ui.components.navigation_drawer.DrawerHeader
import com.juanimozo.weatherapp.ui.components.navigation_drawer.MenuItem
import com.juanimozo.weatherapp.ui.theme.Values
import kotlinx.coroutines.launch

@Composable
fun CurrentForecastDetailsScreen(
    navController: NavController
) {

    val viewModel: ForecastViewModel = hiltViewModel()
    val currentForecast = viewModel.forecastState.value.currentCondition

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationClick = {
                    navController.popBackStack()
                },
                // City Name
                title = "",
                icon = Icons.Default.ArrowBack
            )
        }
    ) { scaffoldPadding ->
        if (currentForecast != null) {
            Column(
                modifier = Modifier.fillMaxSize().padding(scaffoldPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Title
                Row(
                    modifier = Modifier
                        .padding(Values.Padding.medium)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Current Conditions",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h1
                    )
                }
                // Temperature
                Row(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = TemperatureFormat.formatDoubleTemperature(
                            temperature = currentForecast.temperature.Metric.Value,
                            unit = currentForecast.temperature.Metric.Unit
                        ),
                        style = TextStyle(
                            fontFamily = Fonts.MontserratSemiBold,
                            fontSize = 65.sp,
                            color = DarkGreyTeal,
                            letterSpacing = 1.5.sp
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = Values.Padding.small)
                        .fillMaxSize()
                ) {
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
                                temperature = currentForecast.realFeelTemperature.Metric.Value,
                                unit = currentForecast.realFeelTemperature.Metric.Unit)
                        )
                        // Wind Speed
                        CurrentForecastDetailsItem(
                            title = "Wind Speed",
                            content = "${currentForecast.wind.Speed.Metric.Value.toInt()} km/h")
                        // Wind Direction
                        CurrentForecastDetailsItem(
                            title = "Wind Direction",
                            content = currentForecast.wind.Direction.English)
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Humidity
                        CurrentForecastDetailsItem(
                            title = "Humidity",
                            content = "${currentForecast.relativeHumidity}%")
                        // Pressure
                        CurrentForecastDetailsItem(
                            title = "Pressure",
                            content = "${currentForecast.pressure.Metric.Value.toInt()} mb")
                        // Wind Direction
                        CurrentForecastDetailsItem(
                            title = "UV Index",
                            content = currentForecast.uVIndex.toString())
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize().padding(scaffoldPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoadingAnimation(
                    animation = R.raw.loading_animation
                )
            }
        }
    }
}
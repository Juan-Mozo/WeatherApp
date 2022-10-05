package com.juanimozo.weatherapp.presentation.feature_forecast.current_forecast_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.presentation.feature_forecast.ForecastViewModel
import com.juanimozo.weatherapp.presentation.feature_forecast.util.TemperatureFormat
import com.juanimozo.weatherapp.presentation.feature_forecast.animations.LoadingAnimation
import com.juanimozo.weatherapp.ui.theme.DarkGreyTeal
import com.juanimozo.weatherapp.ui.theme.Fonts
import com.juanimozo.weatherapp.R
import com.juanimozo.weatherapp.ui.components.navigation_drawer.AppBar
import com.juanimozo.weatherapp.ui.theme.Values
import org.w3c.dom.Text

@Composable
fun CurrentForecastDetailsScreen(
    navController: NavController
) {

    val viewModel: ForecastViewModel = hiltViewModel()

    val currentForecast = viewModel.forecastState.value.currentCondition
    val isMetric = viewModel.user.value.metric

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationClick = {
                    navController.popBackStack()
                },
                title = "",
                icon = Icons.Default.ArrowBack
            )
        }
    ) { scaffoldPadding ->
        if (currentForecast != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(scaffoldPadding),
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
                        text = stringResource(id = R.string.current_conditions_title),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h1
                    )
                }
                // Temperature
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val temperature = if (isMetric) {
                        TemperatureFormat.formatDoubleTemperature(
                            temperature = currentForecast.temperature.Metric.Value,
                            unit = currentForecast.temperature.Metric.Unit
                        )
                    } else {
                        TemperatureFormat.formatDoubleTemperature(
                            temperature = currentForecast.temperature.Metric.Value,
                            unit = currentForecast.temperature.Metric.Unit
                        )
                    }
                    Text(
                        text = temperature,
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
                        val realFeelTemperature = if (isMetric) {
                            TemperatureFormat.formatDoubleTemperature(
                                temperature = currentForecast.realFeelTemperature.Metric.Value,
                                unit = currentForecast.realFeelTemperature.Metric.Unit
                            )
                        } else {
                            TemperatureFormat.formatIntTemperature(
                                temperature = currentForecast.realFeelTemperature.Imperial.Value,
                                unit = currentForecast.realFeelTemperature.Imperial.Unit)
                        }
                        CurrentForecastDetailsItem(
                            title = stringResource(id = R.string.real_feel_title),
                            content = realFeelTemperature
                        )

                        // Wind Speed
                        val windSpeed = if (isMetric) {
                            currentForecast.wind.Speed.Metric.Value.toInt()
                        } else {
                            currentForecast.wind.Speed.Imperial.Value.toInt()
                        }
                        CurrentForecastDetailsItem(
                            title = stringResource(id = R.string.wind_speed_title),
                            content = "$windSpeed km/h")

                        // Wind Direction
                        CurrentForecastDetailsItem(
                            title = stringResource(id = R.string.wind_direction_title),
                            content = currentForecast.wind.Direction.Localized)
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Humidity
                        CurrentForecastDetailsItem(
                            title = stringResource(id = R.string.humidity_title),
                            content = "${currentForecast.relativeHumidity}%")
                        // Pressure
                        val pressure = if (isMetric) {
                            currentForecast.pressure.Metric.Value.toInt()
                        } else {
                            currentForecast.pressure.Imperial.Value.toInt()
                        }
                        CurrentForecastDetailsItem(
                            title = stringResource(id = R.string.pressure_title),
                            content = "$pressure mb")
                        // Wind Direction
                        CurrentForecastDetailsItem(
                            title = stringResource(id = R.string.uv_index_title),
                            content = currentForecast.uVIndex.toString())
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(scaffoldPadding),
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
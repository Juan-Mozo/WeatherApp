package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.R
import com.juanimozo.weatherapp.presentation.feature_forecast.ForecastViewModel
import com.juanimozo.weatherapp.presentation.feature_forecast.animations.LoadingAnimation
import com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components.CurrentForecastCard
import com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components.daily.DailyForecastItem
import com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components.HourlyForecastItem
import com.juanimozo.weatherapp.ui.components.navigation_drawer.AppBar
import com.juanimozo.weatherapp.ui.components.navigation_drawer.DrawerBody
import com.juanimozo.weatherapp.ui.components.navigation_drawer.DrawerHeader
import com.juanimozo.weatherapp.ui.components.navigation_drawer.MenuItem
import com.juanimozo.weatherapp.presentation.feature_forecast.util.DateTime
import com.juanimozo.weatherapp.ui.theme.Values
import kotlinx.coroutines.launch

@Composable
fun ForecastScreen(
    navController: NavController
) {

    val viewModel: ForecastViewModel = hiltViewModel()
    val forecastState = viewModel.forecastState.value

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
                 AppBar(
                     onNavigationClick = {
                         scope.launch {
                             scaffoldState.drawerState.open()
                         }
                     },
                     // City Name
                     title = viewModel.forecastState.value.currentCityName,
                     icon = Icons.Default.Menu
                 )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = MenuItem.getItems(),
                onItemClick = { item ->
                    when (item) {
                        is MenuItem.LogOut -> { viewModel.deleteAccount(navController, item.route) }
                        else -> {
                            // Navigate to defined route
                            navController.navigate(item.route)
                        }
                    }
                }
            )
        }
    ) { scaffoldPadding ->
        if (viewModel.forecastState.value.isContentLoaded) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(scaffoldPadding)
            ) {
                // Time and Day of the week
                Row(
                    modifier = Modifier
                        .padding(vertical = Values.Padding.medium)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(start = Values.Padding.large),
                        text = DateTime().getDateTime(DateTime.Format.HourDay),
                        style = MaterialTheme.typography.subtitle1
                    )
                }

                Spacer(modifier = Modifier.height(Values.Spacer.small))

                // Card with current temperature
                Row(modifier = Modifier.fillMaxWidth()) {
                    CurrentForecastCard(
                        currentConditions = forecastState.currentCondition,
                        navController = navController
                    )
                }

                Spacer(modifier = Modifier.height(Values.Spacer.medium))

                // Row with all hourly forecast
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(forecastState.hourlyForecast) { hourly ->
                        HourlyForecastItem(item = hourly)
                    }
                }

                Spacer(modifier = Modifier.height(Values.Spacer.medium))

                Divider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(vertical = Values.Padding.small),
                    color = MaterialTheme.colors.primaryVariant
                )

                // Spacer(modifier = Modifier.height(Values.Spacer.medium))

                // Column with weekly forecast
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(forecastState.weeklyForecast) { daily ->
                        DailyForecastItem(item = daily)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                modifier = Modifier
                                    .padding(vertical = Values.Padding.small)
                                    .fillMaxWidth(0.75f),
                                color = MaterialTheme.colors.primaryVariant
                            )
                        }
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(scaffoldPadding)
                ,
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
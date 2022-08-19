package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.juanimozo.weatherapp.domain.model.HourlyForecastModel
import com.juanimozo.feature_forecast.presentation.util.TemperatureFormat

@Composable
fun HourlyForecastItem(item: HourlyForecastModel) {
    Column(modifier = Modifier) {
        Row(horizontalArrangement = Arrangement.Center) {
            // Text with referenced hour
            Text(
                text = item.DateTime
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        // ToDo:: -HourlyForecastItem- *1* / Priority: M
        // Description: Check all icon phrases
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = item.IconPhrase
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        // Temperature
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = TemperatureFormat.formatDoubleTemperature(item.Temperature.Value, item.Temperature.Unit))
        }
    }
}
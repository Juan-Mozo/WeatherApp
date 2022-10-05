package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components.daily

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.juanimozo.weatherapp.presentation.feature_forecast.util.TemperatureFormat
import com.juanimozo.weatherapp.ui.theme.Values

@Composable
fun MinMaxTemp(type: MinMaxType, temperature: Double, unit: String) {
    Row(modifier = Modifier.padding(vertical = Values.Padding.small)) {
        Text(
            text = type.text,
            style = MaterialTheme.typography.body2,
            maxLines = 1
        )
        Text(
            text = TemperatureFormat.formatDoubleTemperature(temperature, unit),
            style = MaterialTheme.typography.body2,
            maxLines = 1
        )
    }
}

sealed class MinMaxType(val text: String) {
    class Minimum(text: String = "Min: "): MinMaxType(text)
    class Maximum(text: String = "Max: "): MinMaxType(text)
}
package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components.daily

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.juanimozo.weatherapp.presentation.feature_forecast.util.DateTime

@Composable
fun DateText(date: String, outputFormat: DateTime.Format) {
    Text(
        text = DateTime().formatDateTime(
            date = date,
            inputFormat = DateTime.Format.ISO8601,
            outputFormat = outputFormat
        ),
        style = MaterialTheme.typography.body2
    )
}
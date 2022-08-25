package com.juanimozo.weatherapp.presentation.feature_forecast.current_forecast_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.juanimozo.weatherapp.ui.theme.Values

@Composable
fun CurrentForecastDetailsItem(title: String, content: String) {
    Column(
        modifier = Modifier
            .padding(vertical = Values.Padding.medium)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = Values.Padding.small)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = content,
                style = MaterialTheme.typography.body1
            )
        }
    }
}
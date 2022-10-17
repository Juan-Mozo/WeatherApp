package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.juanimozo.weatherapp.data.forecast.Forecast
import com.juanimozo.weatherapp.ui.theme.Values

@Composable
fun ForecastDayNight(forecast: Forecast.Weather, phrase: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = Values.Padding.small)
            .fillMaxWidth(),
            // .width(Values.Image.smallWeatherIcon + Values.Padding.medium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(Values.Image.smallWeatherIcon),
                painter = painterResource(id = forecast.icon),
                contentDescription = forecast.text
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = phrase,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )
        }
    }
}
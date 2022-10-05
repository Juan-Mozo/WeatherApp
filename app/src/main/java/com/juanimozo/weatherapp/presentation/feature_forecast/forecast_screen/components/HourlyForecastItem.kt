package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juanimozo.weatherapp.domain.model.HourlyForecastModel
import com.juanimozo.weatherapp.presentation.feature_forecast.util.TemperatureFormat
import com.juanimozo.weatherapp.data.forecast.Forecast
import com.juanimozo.weatherapp.presentation.feature_forecast.util.DateTime
import com.juanimozo.weatherapp.ui.theme.Values

@Composable
fun HourlyForecastItem(item: HourlyForecastModel) {

    val weather: Forecast.Weather = Forecast().setWeatherWithIcon(
        iconNumber = item.weatherIcon
    )

    Column(
        modifier = Modifier.width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            // Text with referenced hour
            Text(
                text = DateTime().formatDateTime(
                    date = item.dateTime,
                    inputFormat = DateTime.Format.ISO8601,
                    outputFormat = DateTime.Format.Hour
                ),
                style = MaterialTheme.typography.body2
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        // Temperature
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier.padding(horizontal = Values.Padding.small),
                text = TemperatureFormat.formatDoubleTemperature(
                    temperature = item.temperature.Value,
                    unit = item.temperature.Unit),
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 24.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier.size(Values.Image.smallWeatherIcon),
                painter = painterResource(id = weather.icon),
                contentDescription = weather.text
            )
        }

    }
}
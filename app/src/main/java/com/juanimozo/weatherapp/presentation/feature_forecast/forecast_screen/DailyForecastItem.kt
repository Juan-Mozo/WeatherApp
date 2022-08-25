package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juanimozo.weatherapp.domain.model.DailyForecastModel
import com.juanimozo.feature_forecast.presentation.util.TemperatureFormat
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.*
import com.juanimozo.weatherapp.ui.theme.WeatherAppTheme
import com.juanimozo.weatherapp.ui.util.QuarterFraction

@Composable
fun DailyForecastItem(item: DailyForecastModel) {
    val fraction = QuarterFraction

    Row(modifier = Modifier.fillMaxWidth()) {
        // Date
        Column(modifier = Modifier.fillMaxWidth(fraction),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = item.Date)
        }
        // Day Icon and Phrase
        Column(modifier = Modifier.fillMaxWidth(fraction),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // ToDo:: -DailyForecastItem- *1* / Priority: M
            // Description: Check Icons
            Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock")
            Text(text = item.Day.IconPhrase)
        }
        // Night Icon and Phrase
        Column(modifier = Modifier.fillMaxWidth(fraction),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = Icons.Default.Warning, contentDescription = "Lock")
            Text(text = item.Night.IconPhrase)
        }
        // Max and Min temperature
        Column(modifier = Modifier.fillMaxWidth(fraction),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val maximum = item.Temperature.Maximum
            val minimum = item.Temperature.Minimum
            Text(text = "Max: ${TemperatureFormat.formatDoubleTemperature(maximum.Value, maximum.Unit)}")
            Text(text = "Min: ${TemperatureFormat.formatDoubleTemperature(minimum.Value, minimum.Unit)}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DailyForecastPreview() {
    WeatherAppTheme {
        DailyForecastItem(
            item = DailyForecastModel(
                Date = "jun 25",
                Day = Day(
                    false,
                    1,
                    "lluvia",
                    "fuerte",
                    ""
                ),
                Night = Night(
                    false,
                    2,
                    "soleado",
                    "fuerte",
                    ""
                ),
                Temperature = Temperature(
                    Maximum = Maximum(
                        "c",
                        2,
                        25.5
                    ),
                    Minimum = Minimum(
                        "c",
                        2,
                        10.21
                    )
                )
            )
        )
    }
}
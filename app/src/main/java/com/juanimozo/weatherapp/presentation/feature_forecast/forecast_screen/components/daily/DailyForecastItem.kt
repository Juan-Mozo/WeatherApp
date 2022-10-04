package com.juanimozo.weatherapp.presentation.feature_forecast.forecast_screen.components.daily

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juanimozo.weatherapp.domain.model.DailyForecastModel
import com.juanimozo.feature_forecast.presentation.util.TemperatureFormat
import com.juanimozo.weatherapp.data.forecast.Forecast
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.*
import com.juanimozo.weatherapp.presentation.feature_forecast.util.DateTime
import com.juanimozo.weatherapp.ui.theme.Values
import com.juanimozo.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun DailyForecastItem(item: DailyForecastModel) {
    Row(
        modifier = Modifier
            .padding(vertical = Values.Padding.small)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = Values.Padding.medium)
                .fillMaxWidth(0.25f)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Day of the week
            DateText(date = item.date, outputFormat = DateTime.Format.DayWeek)
            // Day of the month
            DateText(date = item.date, outputFormat = DateTime.Format.DayMonth)
        }

        // Day Icon and Phrase
        Column(
            modifier = Modifier.fillMaxWidth(0.333f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val dayForecast: Forecast.Weather = Forecast().setWeatherWithIcon(item.day.Icon)
            ForecastDayNight(forecast = dayForecast, phrase = item.day.IconPhrase)
        }
        // Night Icon and Phrase
        Column(
            modifier = Modifier.fillMaxWidth(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val nightForecast: Forecast.Weather = Forecast().setWeatherWithIcon(item.night.Icon)
            ForecastDayNight(forecast = nightForecast, phrase = item.night.IconPhrase)
        }

        // Max and Min temperature
        Column(
            modifier = Modifier
                .padding(horizontal = Values.Padding.small)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Maximum Temperature
            val maximum = item.temperature.Maximum
            MinMaxTemp(
                type = MinMaxType.Maximum(),
                temperature = maximum.Value,
                unit = maximum.Unit)
            // Minimum Temperature
            val minimum = item.temperature.Minimum
            MinMaxTemp(
                type = MinMaxType.Minimum(),
                temperature = minimum.Value,
                unit = minimum.Unit)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DailyForecastPreview() {
    WeatherAppTheme {
        DailyForecastItem(
            item = DailyForecastModel(
                date = "jun 25",
                day = Day(
                    false,
                    1,
                    "lluvia",
                    "fuerte",
                    ""
                ),
                night = Night(
                    false,
                    2,
                    "soleado",
                    "fuerte",
                    ""
                ),
                temperature = Temperature(
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
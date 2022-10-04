package com.juanimozo.weatherapp.data.network.util

import com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions.CurrentConditionsItem
import com.juanimozo.weatherapp.data.network.accuweather_api.hourly_forecast.HourlyForecastItem
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.DailyForecast
import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.domain.model.DailyForecastModel
import com.juanimozo.weatherapp.domain.model.HourlyForecastModel

class ConvertForecastDto {

    fun toHourlyForecastModel(dto: List<HourlyForecastItem>): List<HourlyForecastModel> {
        val convertedDto = dto.map { item ->
            HourlyForecastModel(
                dateTime = item.DateTime,
                hasPrecipitation = item.HasPrecipitation,
                iconPhrase = item.IconPhrase,
                isDaylight = item.IsDaylight,
                precipitationIntensity = item.PrecipitationIntensity,
                precipitationProbability = item.PrecipitationProbability,
                precipitationType = item.PrecipitationType,
                temperature = item.Temperature,
                weatherIcon = item.WeatherIcon
            )
        }
        return convertedDto
    }

    fun toDailyForecastModel(dto: List<DailyForecast>): List<DailyForecastModel> {
        val convertedDto = dto.map { item ->
            DailyForecastModel(
                date = item.Date,
                day = item.Day,
                night = item.Night,
                temperature = item.Temperature
            )
        }
        return convertedDto
    }

    fun toCurrentConditionsModel(dto: List<CurrentConditionsItem>): CurrentConditionsModel {
        // Just take the first of the list
        val first = dto[0]
        // Return the model
        return CurrentConditionsModel(
            cloudCover = first.CloudCover,
            hasPrecipitation = first.HasPrecipitation,
            isDayTime = first.IsDayTime,
            precip1hr = first.Precip1hr,
            pressure = first.Pressure,
            realFeelTemperature = first.RealFeelTemperature,
            relativeHumidity = first.RelativeHumidity,
            temperature = first.Temperature,
            uVIndex = first.UVIndex,
            wind = first.Wind,
            weatherIcon = first.WeatherIcon
        )
    }

}
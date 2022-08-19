package com.juanimozo.weatherapp.data.network.util

import com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions.CurrentConditionsItem
import com.juanimozo.weatherapp.data.network.accuweather_api.hourly_forecast.HourlyForecastItem
import com.juanimozo.weatherapp.data.network.accuweather_api.weekly_forecast.DailyForecast
import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.domain.model.DailyForecastModel
import com.juanimozo.weatherapp.domain.model.HourlyForecastModel

class ConvertForecastDto {

    fun toHourlyForecastModel(dto: List<HourlyForecastItem>): List<HourlyForecastModel>? {
        // Create a new list with the model
        val newList: MutableList<HourlyForecastModel>? = null
        // Convert each HourlyForecastItem to the model and add it to the list
        for (i in dto) {
            newList?.add(
                HourlyForecastModel(
                    DateTime = i.DateTime,
                    HasPrecipitation = i.HasPrecipitation,
                    IconPhrase = i.IconPhrase,
                    IsDaylight = i.IsDaylight,
                    PrecipitationIntensity = i.PrecipitationIntensity,
                    PrecipitationProbability = i.PrecipitationProbability,
                    PrecipitationType = i.PrecipitationType,
                    Temperature = i.Temperature
                )
            )
        }
        return newList
    }

    fun toDailyForecastModel(dto: List<DailyForecast>): List<DailyForecastModel>? {
        // Create a new list with the model
        val newList: MutableList<DailyForecastModel>? = null
        // Convert each DailyForecast to the model and add it to the list
        for (i in dto) {
            newList?.add(
                DailyForecastModel(
                    Date = i.Date,
                    Day = i.Day,
                    Night = i.Night,
                    Temperature = i.Temperature
                )
            )
        }
        return newList
    }

    fun toCurrentConditionsModel(dto: List<CurrentConditionsItem>): CurrentConditionsModel {
        // Just take the first of the list
        val f = dto[0]
        // Return the model
        return CurrentConditionsModel(
            CloudCover = f.CloudCover,
            HasPrecipitation = f.HasPrecipitation,
            IsDayTime = f.IsDayTime,
            Precip1hr = f.Precip1hr,
            Pressure = f.Pressure,
            RealFeelTemperature = f.RealFeelTemperature,
            RelativeHumidity = f.RelativeHumidity,
            Temperature = f.Temperature,
            UVIndex = f.UVIndex,
            Wind = f.Wind
        )
    }

}
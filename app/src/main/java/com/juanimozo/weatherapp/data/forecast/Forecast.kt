package com.juanimozo.weatherapp.data.forecast

import com.juanimozo.weatherapp.R

class Forecast {

    sealed class Weather(val icon: Int, val text: String) {
        class Sunny(icon: Int = R.drawable.sun, text: String = "Sunny"): Weather(icon = icon, text = text)
        class ClearNight(icon: Int = R.drawable.moon, text: String = "Clear night"): Weather(icon = icon, text = text)
        class Cloudy(icon: Int = R.drawable.cloudy, text: String = "Cloudy"): Weather(icon = icon, text = text)
        class CloudyNight(icon: Int = R.drawable.cloudy_night, text: String = "Cloudy night"): Weather(icon = icon, text = text)
        class Rain(icon: Int = R.drawable.rain, text: String = "Rain"): Weather(icon = icon, text = text)
        class RainyNight(icon: Int = R.drawable.drizzle_night, text: String = "Drizzle night"): Weather(icon = icon, text = text)
        class Storm(icon: Int = R.drawable.storm, text: String = "Storm"): Weather(icon = icon, text = text)
        class Snow(icon: Int = R.drawable.snow, text: String = "Snow"): Weather(icon = icon, text = text)
        class Windy(icon: Int = R.drawable.windy, text: String = "Windy"): Weather(icon = icon, text = text)
    }

    fun setWeatherWithIcon(iconNumber: Int): Weather {
        return when (iconNumber) {
            1, 2, 3, 4, 5, 30 -> {
                Weather.Sunny()
            }
            6, 7, 8, 11 -> {
                Weather.Cloudy()
            }
            12, 13, 14 -> {
                Weather.Rain()
            }
            15, 16, 17 -> {
                Weather.Storm()
            }
            18, 19, 20, 21 -> {
                Weather.Rain()
            }
            22, 23, 24, 26, 29, 31 -> {
                Weather.Snow()
            }
            32 -> {
                Weather.Windy()
            }
            33, 34, 35, 36, 37 -> {
                Weather.ClearNight()
            }
            38, 39, 40 -> {
                Weather.CloudyNight()
            }
            41, 42, 43, 44 -> {
                Weather.RainyNight()
            }
            else -> {
                Weather.Sunny()
            }
        }
    }

    fun setWeatherWithPrecipitation(hasPrecipitation: Boolean, isDayTime: Boolean): Weather {

        var weather: Weather = Weather.Sunny()

        if (hasPrecipitation && isDayTime) {
            weather = Weather.Rain()
        }
        if (hasPrecipitation && !isDayTime) {
            weather = Weather.RainyNight()
        }
        if (!hasPrecipitation && isDayTime) {
            weather = Weather.Sunny()
        }
        if (!hasPrecipitation && !isDayTime) {
            weather = Weather.RainyNight()
        }

        return weather
    }

}
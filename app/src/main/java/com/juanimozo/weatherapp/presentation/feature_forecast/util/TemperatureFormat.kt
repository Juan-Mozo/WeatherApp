package com.juanimozo.weatherapp.presentation.feature_forecast.util

import kotlin.math.roundToInt

class TemperatureFormat {

    companion object {

        fun formatIntTemperature(temperature: Int, unit: String): String {
            return "$temperature°${unit.uppercase()}"
        }

        fun formatDoubleTemperature(temperature: Double, unit: String): String {
            return "${roundDouble(temperature)}°${unit.uppercase()}"
        }

        // Round temperature to 2 decimals
        private fun roundDouble(double: Double): Int {
            return (double * 100).roundToInt() / 100
        }

    }
}
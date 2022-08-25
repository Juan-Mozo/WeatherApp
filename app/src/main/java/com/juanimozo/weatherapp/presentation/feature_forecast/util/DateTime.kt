package com.juanimozo.weatherapp.presentation.feature_forecast.util

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DateTime(private val format: Format) {

    fun getDateTime(): String {
        // LocalDateTime requires API Level 26
        val formattedTime: String = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val currentTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern(format.format)
            currentTime.format(formatter)
        } else {
            // If API Level is less than 26 then use Calendar
            val currentTime = Calendar.getInstance().time
            currentTime.toString(format.format)
        }

        return formattedTime
    }

    // Formatter for Calendar
    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    enum class Format(val format: String) {
        HourDay("HH:mm EE")
    }

}
package com.juanimozo.weatherapp.presentation.feature_forecast.util

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DateTime() {

    fun getDateTime(format: Format): String {
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

    fun formatDateTime(date: String, inputFormat: Format, outputFormat: Format): String {
        val formattedTime: String = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Convert to LocalDate
            val inputFormatter = DateTimeFormatter.ISO_DATE_TIME
            val formattedDate = LocalDateTime.parse(date, inputFormatter)

            // Parse to new format
            val formatter = DateTimeFormatter.ofPattern(outputFormat.format)
            formattedDate.format(formatter)
        } else {
            // Convert to Date
            stringToDate(date, inputFormat)
                    // Parse with new format
                ?.toString(outputFormat.format) ?: date
        }
        return formattedTime
    }

    // Formatter for Calendar
    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    private fun stringToDate(date: String, dateFormat: Format, locale: Locale = Locale.getDefault()): Date? {
        val formatter = SimpleDateFormat(dateFormat.format, locale)
        return formatter.parse(date)

    }

    enum class Format(val format: String) {
        HourDay("HH:mm EEEE"),
        ISO8601("yyyy-MM-dd'T'HH:mm'Z'"),
        DayWeek("EEEE"),
        DayMonth("MM-dd"),
        Hour("HH:mm")
    }

}
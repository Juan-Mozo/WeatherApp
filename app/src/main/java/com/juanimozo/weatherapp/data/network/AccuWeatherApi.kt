package com.juanimozo.weatherapp.data.network

import com.juanimozo.weatherapp.data.network.accuweather_api.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AccuWeatherApi {

    @GET("/locations/v1/cities/search?apikey=$API_KEY")
    suspend fun searchCity(
        @Query("q") q: String,
        @Query("language") language: String
    ): CitySearch

    @GET("/forecasts/v1/hourly/12hour/{locationKey}?apikey=$API_KEY")
    suspend fun getHourlyForecast(
        @Path("locationKey") locationKey: Int,
        @Query("language") language: String,
        @Query("metric") metric: Boolean
    ): HourlyForecast

    @GET("/forecasts/v1/daily/5day/{locationKey}?apikey=$API_KEY")
    suspend fun getWeeklyForecast(
        @Path("locationKey") locationKey: Int,
        @Query("language") language: String,
        @Query("metric") metric: Boolean
    ): WeeklyForecast

    @GET("/currentconditions/v1/{locationKey}?apikey=$API_KEY&details=true")
    suspend fun getCurrentConditions(
        @Path("locationKey") locationKey: Int
    ): CurrentConditions

    @GET("/locations/v1/cities/geoposition/search?apikey=$API_KEY")
    suspend fun searchLocationByGeoPosition(
        @Query("q") q: String,
        @Query("language") language: String
    ): GeoPosition

    companion object {
        const val BASE_URL = "https://dataservice.accuweather.com/"
        const val API_KEY = "2tFgV8NKjPdY35K0mLepoQoNC2kMkAin"
    }

}
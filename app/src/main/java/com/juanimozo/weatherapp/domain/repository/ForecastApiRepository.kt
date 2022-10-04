package com.juanimozo.weatherapp.domain.repository

import com.juanimozo.weatherapp.domain.model.CityModel
import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.domain.model.DailyForecastModel
import com.juanimozo.weatherapp.domain.model.HourlyForecastModel
import com.juanimozo.weatherapp.util.resource.Resource
import kotlinx.coroutines.flow.Flow

interface ForecastApiRepository {

    fun getHourlyForecast(locationKey: Int, language: String, metric: Boolean): Flow<Resource<List<HourlyForecastModel>>>

    fun getWeeklyForecast(locationKey: Int, language: String, metric: Boolean): Flow<Resource<List<DailyForecastModel>>>

    fun getCurrentConditions(locationKey: Int, language: String): Flow<Resource<CurrentConditionsModel>>

    fun searchCityByName(query: String, language: String): Flow<Resource<List<CityModel>>>

    fun searchCityByGeoPosition(query: String, language: String): Flow<Resource<CityModel>>

}
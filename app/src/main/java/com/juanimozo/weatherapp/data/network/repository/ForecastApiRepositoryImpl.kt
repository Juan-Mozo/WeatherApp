package com.juanimozo.weatherapp.data.network.repository

import com.juanimozo.weatherapp.data.network.util.ConvertCityDto
import com.juanimozo.weatherapp.data.network.util.ConvertForecastDto
import com.juanimozo.weatherapp.domain.model.CityModel
import com.juanimozo.weatherapp.domain.model.CurrentConditionsModel
import com.juanimozo.weatherapp.domain.model.DailyForecastModel
import com.juanimozo.weatherapp.domain.model.HourlyForecastModel
import com.juanimozo.weatherapp.domain.repository.ForecastApiRepository
import com.juanimozo.weatherapp.util.resource.Resource
import com.juanimozo.weatherapp.data.network.AccuWeatherApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

const val TAG = "ForecastApiRepositoryImpl"

class ForecastApiRepositoryImpl @Inject constructor(
    private val api: AccuWeatherApi
): ForecastApiRepository {

    override fun getHourlyForecast(
        locationKey: Int, language: String, metric: Boolean
    ): Flow<Resource<List<HourlyForecastModel>>> = flow {
        try {
            // Get hourly forecast from AccuWeatherApi
            val hourlyForecastDto = api.getHourlyForecast(locationKey, language, metric).toList()
            // Convert dto to model
            val hourlyForecast = ConvertForecastDto().toHourlyForecastModel(hourlyForecastDto)
            // Emit result
            emit(Resource.Success(data = hourlyForecast))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Something went wrong: ${e.message}"))
        }
    }

    override fun getWeeklyForecast(
        locationKey: Int, language: String, metric: Boolean
    ): Flow<Resource<List<DailyForecastModel>>> = flow {
        try {
            // Get weekly forecast from AccuWeatherApi
            val weeklyForecastDto = api.getWeeklyForecast(locationKey, language, metric)
            // Convert dto to model
            val weeklyForecast = ConvertForecastDto().toDailyForecastModel(weeklyForecastDto.DailyForecasts)
            // Emit result
            emit(Resource.Success(data = weeklyForecast))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Something went wrong: ${e.message}"))
        }
    }

    override fun getCurrentConditions(
        locationKey: Int, language: String
    ): Flow<Resource<CurrentConditionsModel>> = flow {
        try {
            // Get current forecast conditions from AccuWeatherApi
            val currentForecastDto = api.getCurrentConditions(locationKey, language)
            // Convert dto to model. Just take the first result
            val currentConditions = ConvertForecastDto().toCurrentConditionsModel(currentForecastDto)
            // Emit result
            emit(Resource.Success(data = currentConditions))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Something went wrong: ${e.message}"))
        }
    }

    override fun searchCityByName(
        query: String, language: String
    ): Flow<Resource<List<CityModel>>> = flow {
        try {
            val citiesDto = api.searchCity(q = query, language = language).toList()
            val cities = ConvertCityDto.ToCityModel.fromSearchCity(citiesDto)
            emit(Resource.Success(data = cities))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Something went wrong: ${e.message}"))
        }
    }

    override fun searchCityByGeoPosition(
        query: String, language: String
    ): Flow<Resource<CityModel>> = flow {
        try {
            val cityDto = api.searchLocationByGeoPosition(q = query, language = language)
            val city = ConvertCityDto.ToCityModel.fromGeoPosition(cityDto)
            emit(Resource.Success(data = city))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Something went wrong: ${e.message}"))
        }
    }


}
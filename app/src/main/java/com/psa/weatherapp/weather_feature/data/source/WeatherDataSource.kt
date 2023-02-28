package com.psa.weatherapp.weather_feature.data.source

import com.psa.weatherapp.weather_feature.data.Weather
import kotlinx.coroutines.flow.Flow


interface WeatherDataSource {
    suspend fun saveCityWeather(cityWeather: Weather)
    fun getCityWeatherStreamById(cityId: String): Flow<Result<Weather>>
    suspend fun refreshCityWeather(cityId: String)
    suspend fun deleteCityWeather(cityId: String)

}
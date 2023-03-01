package com.psa.openweathermaplibrary.weather_feature.data.source

import com.psa.openweathermaplibrary.weather_feature.data.Result
import com.psa.openweathermaplibrary.weather_feature.data.Weather
import kotlinx.coroutines.flow.Flow


interface WeatherDataSource {
    suspend fun saveCityWeather(cityWeather: Weather)
    fun getCityWeatherStreamById(cityId: String): Flow<Result<Weather>>
    suspend fun getCityWeatherById(cityId: String): Result<Weather>
    suspend fun refreshCityWeather(cityId: String)
    suspend fun deleteCityWeather(cityId: String)

}
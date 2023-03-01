package com.psa.openweathermaplibrary.data.source

import com.psa.openweathermaplibrary.data.Result
import com.psa.openweathermaplibrary.data.Weather
import kotlinx.coroutines.flow.Flow


interface WeatherDataSource {
    suspend fun saveCityWeather(cityWeather: Weather)
    fun getCityWeatherStreamById(cityId: String): Flow<Result<Weather>>
    suspend fun getCityWeatherById(cityId: String): Result<Weather>
    suspend fun refreshCityWeather(cityId: String)
    suspend fun deleteCityWeather(cityId: String)

}
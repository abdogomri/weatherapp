package com.psa.openweathermaplibrary.data.source

import com.psa.openweathermaplibrary.data.Weather
import kotlinx.coroutines.flow.Flow
import com.psa.openweathermaplibrary.data.Result


interface WeatherRepository {
    suspend fun saveCityWeather(cityWeather: Weather)
    fun getCityWeatherStream(cityId: String): Flow<Result<Weather>>
    suspend fun getCityWeather(cityId: String, forceUpdate: Boolean = false): Result<Weather>
    suspend fun refreshCityWeather(cityId: String)
    suspend fun deleteCityWeather(cityId: String)

}
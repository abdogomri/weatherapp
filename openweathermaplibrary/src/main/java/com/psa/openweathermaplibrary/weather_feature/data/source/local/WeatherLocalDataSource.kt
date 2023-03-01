package com.psa.openweathermaplibrary.weather_feature.data.source.local

import com.psa.openweathermaplibrary.weather_feature.data.Result
import com.psa.openweathermaplibrary.weather_feature.data.Result.Success
import com.psa.openweathermaplibrary.weather_feature.data.Result.Error
import com.psa.openweathermaplibrary.weather_feature.data.Weather
import com.psa.openweathermaplibrary.weather_feature.data.source.WeatherDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class WeatherLocalDataSource internal constructor(
    private val weatherDao: WeatherDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): WeatherDataSource {


    override suspend fun saveCityWeather(cityWeather: Weather) = withContext(ioDispatcher) {
        weatherDao.insertCityWeather(cityWeather)
    }

    override fun getCityWeatherStreamById(cityId: String): Flow<Result<Weather>> {
        return weatherDao.observeCityWeatherById(cityId).map {
            Success(it)
        }
    }

    override suspend fun getCityWeatherById(cityId: String): Result<Weather> = withContext(ioDispatcher) {
        try {
            val cityWeather = weatherDao.getCityWeatherById(cityId)
            if (cityWeather != null) {
                return@withContext Success(cityWeather)
            } else {
                return@withContext Error(Exception("city weather not found!"))
            }
        } catch (e: Exception) {
            return@withContext Error(e)
        }
    }

    override suspend fun refreshCityWeather(cityId: String) {
        // NO-OP
    }

    override suspend fun deleteCityWeather(cityId: String) = withContext<Unit>(ioDispatcher){
        weatherDao.deleteCityWeatherById(cityId)
    }
}
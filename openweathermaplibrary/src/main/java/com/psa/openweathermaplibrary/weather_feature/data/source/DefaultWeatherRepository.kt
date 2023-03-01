package com.psa.openweathermaplibrary.weather_feature.data.source

import com.psa.openweathermaplibrary.weather_feature.data.Result
import com.psa.openweathermaplibrary.weather_feature.data.Weather
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DefaultWeatherRepository(
    private val weatherRemoteDataSource: WeatherDataSource,
    private val weatherLocalDataSource: WeatherDataSource,
): WeatherRepository {
    override suspend fun saveCityWeather(cityWeather: Weather) {
        coroutineScope {
            launch {
                weatherLocalDataSource.saveCityWeather(cityWeather)
            }
        }
    }

    override fun getCityWeatherStream(cityId: String): Flow<Result<Weather>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCityWeather(cityId: String, forceUpdate: Boolean): Result<Weather> {
        if (forceUpdate) {
            try {
            refreshCityWeather(cityId)
            } catch (ex: java.lang.Exception) {
                return Result.Error(ex)
            }
        }
        return weatherLocalDataSource.getCityWeatherById(cityId)
    }

    override suspend fun refreshCityWeather(cityId: String) {
        val cityWeather = weatherRemoteDataSource.getCityWeatherById(cityId)
        if (cityWeather is Result.Success) {
            weatherLocalDataSource.saveCityWeather(cityWeather.data)
        } else if (cityWeather is Result.Error) {
            throw cityWeather.exception
        }
    }

    override suspend fun deleteCityWeather(cityId: String) {
        coroutineScope {
            launch {
                weatherLocalDataSource.deleteCityWeather(cityId)
            }
        }
    }
}
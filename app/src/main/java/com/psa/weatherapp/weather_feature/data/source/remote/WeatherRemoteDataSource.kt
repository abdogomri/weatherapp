package com.psa.weatherapp.weather_feature.data.source.remote

import com.psa.weatherapp.weather_feature.data.Result
import com.psa.weatherapp.weather_feature.data.Weather
import com.psa.weatherapp.weather_feature.data.source.WeatherDataSource
import kotlinx.coroutines.flow.Flow

class WeatherRemoteDataSource: WeatherDataSource {
    override suspend fun saveCityWeather(cityWeather: Weather) {
        // Not required for the remote data source
    }

    override fun getCityWeatherStreamById(cityId: String): Flow<Result<Weather>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCityWeatherById(cityId: String): Result<Weather> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshCityWeather(cityId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCityWeather(cityId: String) {
        TODO("Not yet implemented")
    }
}
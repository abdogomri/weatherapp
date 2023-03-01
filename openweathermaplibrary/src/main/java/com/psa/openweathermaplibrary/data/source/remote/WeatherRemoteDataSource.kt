package com.psa.openweathermaplibrary.data.source.remote

import com.psa.openweathermaplibrary.data.ApiInterface
import com.psa.openweathermaplibrary.data.Result
import com.psa.openweathermaplibrary.data.Weather
import com.psa.openweathermaplibrary.data.source.WeatherDataSource
import com.psa.openweathermaplibrary.data.source.remote.mappers.toWeather
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRemoteDataSource @Inject constructor(
    private val api: ApiInterface
): WeatherDataSource {
    override suspend fun saveCityWeather(cityWeather: Weather) {
        // Not required for the remote data source
    }

    override fun getCityWeatherStreamById(cityId: String): Flow<Result<Weather>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCityWeatherById(cityId: String): Result<Weather> {
        api.getCityWeather(cityId = cityId)?.let {
            return Result.Success(it.toWeather())
        }
        return Result.Error(Exception("city weather not found"))
    }

    override suspend fun refreshCityWeather(cityId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCityWeather(cityId: String) {
        TODO("Not yet implemented")
    }
}
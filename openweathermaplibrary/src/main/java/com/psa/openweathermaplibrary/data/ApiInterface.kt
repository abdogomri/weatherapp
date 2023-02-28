package com.psa.openweathermaplibrary.data

import com.psa.openweathermaplibrary.BuildConfig
import com.psa.openweathermaplibrary.cityinfo.data.remote.CityInfo
import com.psa.openweathermaplibrary.cityweather.data.remote.CityWeather
import com.psa.openweathermaplibrary.utils.Constants.FIND_END_POINT
import com.psa.openweathermaplibrary.utils.Constants.METRIC_MODE
import com.psa.openweathermaplibrary.utils.Constants.WEATHER_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface{

    @GET(WEATHER_END_POINT)
    suspend fun getCityWeather(
        @Query("id") cityId: String,
        @Query("units") units: String = METRIC_MODE,
        @Query("appid") appId: String = BuildConfig.api_key
    ): CityWeather

    @GET(FIND_END_POINT)
    suspend fun getCitiesListByName(
        @Query("q") searchQuery: String,
        @Query("appid") appId: String = BuildConfig.api_key
    ): CityInfo

}
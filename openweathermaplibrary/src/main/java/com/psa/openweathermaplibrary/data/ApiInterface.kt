package com.psa.openweathermaplibrary.data

import com.psa.openweathermaplibrary.data.remote.CityWeather
import com.psa.openweathermaplibrary.utils.Constants.METRIC_MODE
import com.psa.openweathermaplibrary.utils.Constants.WEATHER
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface{

    @GET(WEATHER)
    suspend fun getCityWeather(
        @Query("id") cityId: String,
        @Query("units") units: String = METRIC_MODE,
        @Query("appid") appId: String = com.psa.openweathermaplibrary.BuildConfig.api_key
    ): CityWeather

}
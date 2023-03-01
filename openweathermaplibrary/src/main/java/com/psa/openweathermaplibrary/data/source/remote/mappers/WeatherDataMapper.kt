package com.psa.openweathermaplibrary.data.source.remote.mappers

import com.psa.openweathermaplibrary.data.source.remote.model.CityWeather
import com.psa.openweathermaplibrary.data.Weather
import com.psa.openweathermaplibrary.data.source.remote.model.CityInfo

fun CityWeather.toWeather(): Weather {
    return Weather(
        id = id.toString(),
        cityName = name,
        country = sys.country,
        description = weather[0].description,
        icon = weather[0].icon,
        temperature = main.temp.toString(),
        feelsLike = main.feelsLike.toString(),
        tempMin = main.tempMin.toString(),
        tempMax = main.tempMax.toString(),
        humidity = main.humidity.toString(),
        windSpeed = wind.speed.toString(),
        windDegree = wind.deg.toString()
    )
}

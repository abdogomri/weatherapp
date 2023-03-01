package com.psa.openweathermaplibrary.weather_feature.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp"       ) var temp      : Int    = 0,
    @SerializedName("feels_like" ) var feelsLike : Double = 0.0,
    @SerializedName("temp_min"   ) var tempMin   : Double = 0.0,
    @SerializedName("temp_max"   ) var tempMax   : Double = 0.0,
    @SerializedName("pressure"   ) var pressure  : Int    = 0,
    @SerializedName("humidity"   ) var humidity  : Int    = 0
)

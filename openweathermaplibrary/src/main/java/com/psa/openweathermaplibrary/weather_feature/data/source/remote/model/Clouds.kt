package com.psa.openweathermaplibrary.weather_feature.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all" ) var all : Int? = null

)

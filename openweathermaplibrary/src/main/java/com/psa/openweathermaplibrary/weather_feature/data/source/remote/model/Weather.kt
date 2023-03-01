package com.psa.openweathermaplibrary.weather_feature.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("main"        ) var main        : String? = null,
    @SerializedName("description" ) var description : String = "",
    @SerializedName("icon"        ) var icon        : String = ""
)

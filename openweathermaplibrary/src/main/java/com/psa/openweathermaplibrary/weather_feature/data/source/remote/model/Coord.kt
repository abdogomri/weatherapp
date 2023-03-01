package com.psa.openweathermaplibrary.weather_feature.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lon" ) var lon : Double? = null,
    @SerializedName("lat" ) var lat : Double? = null
)

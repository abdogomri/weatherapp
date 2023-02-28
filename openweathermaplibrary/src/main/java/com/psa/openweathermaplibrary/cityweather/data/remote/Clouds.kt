package com.psa.openweathermaplibrary.cityweather.data.remote

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all" ) var all : Int? = null

)

package com.psa.openweathermaplibrary.data.remote

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all" ) var all : Int? = null

)

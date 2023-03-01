package com.psa.openweathermaplibrary.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class CityWeather(
    @SerializedName("coord"      ) var coord      : Coord?             = Coord(),
    @SerializedName("weather"    ) var weather    : ArrayList<Weather> = arrayListOf(),
    @SerializedName("base"       ) var base       : String?            = null,
    @SerializedName("main"       ) var main       : Main = Main(),
    @SerializedName("visibility" ) var visibility : Int?               = null,
    @SerializedName("wind"       ) var wind       : Wind = Wind(),
    @SerializedName("clouds"     ) var clouds     : Clouds?            = Clouds(),
    @SerializedName("dt"         ) var dt         : Int?               = null,
    @SerializedName("sys"        ) var sys        : Sys = Sys(),
    @SerializedName("timezone"   ) var timezone   : Int?               = null,
    @SerializedName("id"         ) var id         : Int,
    @SerializedName("name"       ) var name       : String              = "",
    @SerializedName("cod"        ) var cod        : Int?               = null
)

data class Clouds(
    @SerializedName("all" ) var all : Int? = null

)

data class Coord(
    @SerializedName("lon" ) var lon : Double? = null,
    @SerializedName("lat" ) var lat : Double? = null
)

data class Main(
    @SerializedName("temp"       ) var temp      : Int    = 0,
    @SerializedName("feels_like" ) var feelsLike : Double = 0.0,
    @SerializedName("temp_min"   ) var tempMin   : Double = 0.0,
    @SerializedName("temp_max"   ) var tempMax   : Double = 0.0,
    @SerializedName("pressure"   ) var pressure  : Int    = 0,
    @SerializedName("humidity"   ) var humidity  : Int    = 0
)

data class Sys(
    @SerializedName("type"    ) var type    : Int?    = null,
    @SerializedName("id"      ) var id      : Int?    = null,
    @SerializedName("country" ) var country : String = "",
    @SerializedName("sunrise" ) var sunrise : Int?    = null,
    @SerializedName("sunset"  ) var sunset  : Int?    = null
)
data class Weather(
    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("main"        ) var main        : String? = null,
    @SerializedName("description" ) var description : String = "",
    @SerializedName("icon"        ) var icon        : String = ""
)

data class Wind(
    @SerializedName("speed" ) var speed : Double = 0.0,
    @SerializedName("deg"   ) var deg   : Int    = 0
)

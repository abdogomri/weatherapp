package com.psa.openweathermaplibrary.cityinfo.data.remote

import com.google.gson.annotations.SerializedName


data class CityInfo (

  @SerializedName("message" ) var message : String?         = null,
  @SerializedName("cod"     ) var cod     : String?         = null,
  @SerializedName("count"   ) var count   : Int?            = null,
  @SerializedName("list"    ) var list    : ArrayList<List> = arrayListOf()

)
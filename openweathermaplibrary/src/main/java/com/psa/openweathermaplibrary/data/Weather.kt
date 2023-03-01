package com.psa.openweathermaplibrary.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class Weather  @JvmOverloads  constructor(
    @PrimaryKey @ColumnInfo(name = "cityid") var id:String = "",
    @ColumnInfo(name = "cityname") var cityName: String = "",
    @ColumnInfo(name = "country") var country: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "icon") var icon: String = "",
    @ColumnInfo(name = "temp") var temperature: String = "",
    @ColumnInfo(name = "feelslike") var feelsLike: String = "",
    @ColumnInfo(name = "tempmin") var tempMin: String = "",
    @ColumnInfo(name = "tempmax") var tempMax: String = "",
    @ColumnInfo(name = "humidity") var humidity: String = "",
    @ColumnInfo(name = "windspeed") var windSpeed: String = "",
    @ColumnInfo(name = "winddeg") var windDegree: String = "",
) {
    val isEmpty
        get() = cityName.isEmpty() || temperature.isEmpty()
}

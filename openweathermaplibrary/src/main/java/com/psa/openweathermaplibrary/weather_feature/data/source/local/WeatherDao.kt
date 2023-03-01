package com.psa.openweathermaplibrary.weather_feature.data.source.local

import androidx.room.*
import com.psa.openweathermaplibrary.weather_feature.data.Weather
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    /**
     * Insert a city weather object in the database. If the city weather already exists, replace it.
     *
     * @param cityWeather the cityWeather to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCityWeather(cityWeather: Weather)

    /**
     * Observes a single weather object.
     *
     * @param cityId the city id.
     * @return a Stream of the weather of the city with cityId.
     */
    @Query("SELECT * FROM Weather WHERE cityid = :cityId")
    fun observeCityWeatherById(cityId: String): Flow<Weather>

    /**
     * Select a weather object by id.
     *
     * @param cityId the city id.
     * @return the weather of the city with cityId.
     */
    @Query("SELECT * FROM Weather WHERE cityid = :cityId")
    suspend fun getCityWeatherById(cityId: String): Weather?


    /**
     * Delete a weather object by id.
     *
     * @return the number of weather object deleted. This should always be 1.
     */
    @Query("DELETE FROM Weather WHERE cityid = :cityId")
    suspend fun deleteCityWeatherById(cityId: String): Int


}
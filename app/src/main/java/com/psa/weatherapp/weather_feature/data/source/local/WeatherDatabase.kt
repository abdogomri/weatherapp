package com.psa.weatherapp.weather_feature.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.psa.weatherapp.weather_feature.data.Weather

/**
 * The Room Database that contains the Weather table.
 *
 * exportSchema set to false means database is in-memory only
 * Note that exportSchema should be true in production databases.
 */

@Database(entities = [Weather::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
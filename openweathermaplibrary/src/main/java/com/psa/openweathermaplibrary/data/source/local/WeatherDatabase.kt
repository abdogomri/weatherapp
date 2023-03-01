package com.psa.openweathermaplibrary.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.psa.openweathermaplibrary.data.Weather

/**
 * The Room Database that contains the Weather table.
 *
 * exportSchema set to false means database is in-memory only
 * Note that exportSchema should be true in production databases.
 */

@Database(entities = [Weather::class], version = 1, exportSchema = true)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
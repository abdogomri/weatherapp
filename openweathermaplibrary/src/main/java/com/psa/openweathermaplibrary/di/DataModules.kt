package com.psa.weatherapp.di

import android.content.Context
import androidx.room.Room
import com.psa.openweathermaplibrary.data.ApiInterface
import com.psa.openweathermaplibrary.data.ApiInterfaceContainer
import com.psa.openweathermaplibrary.weather_feature.data.source.local.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideOnlineApiInterface(container: ApiInterfaceContainer): ApiInterface {
        return container.provideApiInterface()
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            WeatherDatabase::class.java,
            "Weather.db"
        ).build()
    }
}
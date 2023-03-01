package com.psa.openweathermaplibrary.di

import android.content.Context
import androidx.room.Room
import com.psa.openweathermaplibrary.data.ApiInterface
import com.psa.openweathermaplibrary.data.ApiInterfaceContainer
import com.psa.openweathermaplibrary.data.source.DefaultWeatherRepository
import com.psa.openweathermaplibrary.data.source.WeatherDataSource
import com.psa.openweathermaplibrary.data.source.WeatherRepository
import com.psa.openweathermaplibrary.data.source.local.WeatherDatabase
import com.psa.openweathermaplibrary.data.source.local.WeatherLocalDataSource
import com.psa.openweathermaplibrary.data.source.remote.WeatherRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RemoteWeatherDataSource

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalWeatherDataSource

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(
        @RemoteWeatherDataSource remoteDataSource: WeatherDataSource,
        @LocalWeatherDataSource localDataSource: WeatherDataSource,
    ): WeatherRepository {
        return DefaultWeatherRepository(remoteDataSource, localDataSource)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @RemoteWeatherDataSource
    @Provides
    fun provideWeatherRemoteDataSource(
        api: ApiInterface
    ): WeatherDataSource {
        return WeatherRemoteDataSource(api)
    }

    @Singleton
    @LocalWeatherDataSource
    @Provides
    fun provideWeatherLocalDataSource(
        database: WeatherDatabase,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): WeatherDataSource {
        return WeatherLocalDataSource(database.weatherDao(), ioDispatcher)
    }

}

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideOnlineApiInterface(container: ApiInterfaceContainer): ApiInterface {
        return container.provideApiInterface()
    }

}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


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
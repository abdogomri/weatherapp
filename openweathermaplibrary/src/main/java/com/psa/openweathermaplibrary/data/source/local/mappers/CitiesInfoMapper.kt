package com.psa.openweathermaplibrary.data.source.local.mappers

import com.psa.openweathermaplibrary.data.source.local.model.LocalCityInfo
import com.psa.openweathermaplibrary.data.source.remote.model.CitiesSearchInfo

fun CitiesSearchInfo.toLocalCitiesInfo(): ArrayList<LocalCityInfo> {
    val citiesListInfo = ArrayList<LocalCityInfo>()
    this.list.forEach {
        citiesListInfo.add(
            LocalCityInfo(
                cityId = it.id.toString(),
                cityName = it.name.toString(),
                countryName = it.sys.country
            )
        )
    }
    return citiesListInfo
}
package org.example.weatherappkotlin.data.db

/**
 * Created by alexandra.ferreira on 17/4/17.
 */


object CityForecastTable {

    val NAME = "DbClasses"
    val ID = "_id"
    val CITY = "city"
    val COUNTRY = "country"

}

object DayForecastTable {

    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID = "cityId"

}




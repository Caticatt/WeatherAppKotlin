package org.example.weatherappkotlin.data.server

import com.google.gson.Gson
import org.example.weatherappkotlin.domain.datasource.ForecastDataSource
import org.example.weatherappkotlin.data.db.ForecastDb
import java.net.URL

/**
 * Created by alexandra.ferreira on 12/4/17.
 */

//Our request simply recieves an zipcode, reads the result an outputs the json in the Logcat.
//The implementation is really easy when using readText, an extension function from the Kotlin
// standar library. This is not recommended for huge responses, but it will be enough in this case.

class ForecastByZipCodeRequest(val zipcode: Long, val gson: Gson = Gson()) {

    companion object {
        private val APP_ID = "6a3c904b80779457bec537647fe0a260"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipcode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}


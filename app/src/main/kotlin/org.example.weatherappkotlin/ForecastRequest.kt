package org.example.weatherappkotlin

import android.util.Log
import com.google.gson.Gson
import data.ResponseClasses
import java.net.URL

/**
 * Created by alexandra.ferreira on 12/4/17.
 */

//Our request simply recieves an zipcode, reads the result an outputs the json in the Logcat.
//The implementation is really easy when using readText, an extension function from the Kotlin
// standar library. This is not recommended for huge responses, but it will be enough in this case.

class ForecastRequest(val zipcode: String) {

    companion object {
        private val APP_ID = "6a3c904b80779457bec537647fe0a260"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ResponseClasses.ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipcode).readText()
        return Gson().fromJson(forecastJsonStr, ResponseClasses.ForecastResult::class.java)
    }
}
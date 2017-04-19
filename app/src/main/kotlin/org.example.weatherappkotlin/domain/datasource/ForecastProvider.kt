package org.example.weatherappkotlin.domain.datasource

import org.example.weatherappkotlin.data.db.ForecastDb
import org.example.weatherappkotlin.data.server.ForecastServer
import org.example.weatherappkotlin.domain.model.ForecastList
import org.example.weatherappkotlin.extensions.firstResult

/**
 * Created by alexandra.ferreira on 19/4/17.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())

    }

    fun requestForecastByZipCode(zipCode: Long, days: Int): ForecastList = sources.firstResult {
        requestSource(it, days, zipCode)
    }

    fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS


}
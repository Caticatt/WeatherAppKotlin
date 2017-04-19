package org.example.weatherappkotlin.domain.datasource

import org.example.weatherappkotlin.data.db.Generics
import org.example.weatherappkotlin.data.server.ForecastServer
import org.example.weatherappkotlin.domain.model.Forecast
import org.example.weatherappkotlin.domain.model.ForecastList
import org.example.weatherappkotlin.extensions.firstResult

/**
 * Created by alexandra.ferreira on 19/4/17.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(Generics(), ForecastServer())

    }

    fun requestForecastByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requesForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T

            = sources.firstResult { f(it) }

}
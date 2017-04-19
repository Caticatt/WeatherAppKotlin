package org.example.weatherappkotlin.data.server

import org.example.weatherappkotlin.domain.datasource.ForecastDataSource
import org.example.weatherappkotlin.data.db.ForecastDb
import org.example.weatherappkotlin.domain.model.Forecast
import org.example.weatherappkotlin.domain.model.ForecastList

/**
 * Created by alexandra.ferreira on 19/4/17.
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(), val forecastDb:
ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long): Forecast? = throw UnsupportedOperationException()

}
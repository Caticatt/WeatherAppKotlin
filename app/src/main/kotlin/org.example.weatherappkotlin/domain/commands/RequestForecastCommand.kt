package org.example.weatherappkotlin.domain.commands


import org.example.weatherappkotlin.domain.datasource.ForecastProvider
import org.example.weatherappkotlin.domain.model.ForecastList

/**
 * Created by alexandra.ferreira on 12/4/17.
 */
class RequestForecastCommand(val zipCode: Long, val forecastProvider: ForecastProvider =
ForecastProvider()) : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestForecastByZipCode(zipCode, DAYS)
    }

}
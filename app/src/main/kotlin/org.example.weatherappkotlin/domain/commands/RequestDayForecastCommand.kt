package org.example.weatherappkotlin.domain.commands

import org.example.weatherappkotlin.domain.datasource.ForecastProvider
import org.example.weatherappkotlin.domain.model.Forecast

/**
 * Created by alexandra.ferreira on 19/4/17.
 */
class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {

    override fun execute() = forecastProvider.requesForecast(id)

}
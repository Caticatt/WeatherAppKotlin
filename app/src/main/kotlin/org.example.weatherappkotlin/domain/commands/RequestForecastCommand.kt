package org.example.weatherappkotlin.domain.commands


import org.example.weatherappkotlin.data.server.ForecastRequest
import org.example.weatherappkotlin.domain.mappers.ForecastDataMapper
import org.example.weatherappkotlin.domain.model.ForecastList

/**
 * Created by alexandra.ferreira on 12/4/17.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}
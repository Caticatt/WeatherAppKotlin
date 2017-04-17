package org.example.weatherappkotlin.domain.mappers

import org.example.weatherappkotlin.data.server.Forecast
import org.example.weatherappkotlin.data.server.ForecastResult
import org.example.weatherappkotlin.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit


//As we are using two classes with the same name, we can give a specific name to one of them so
//that we don’t need to write the complete package:
import org.example.weatherappkotlin.domain.model.Forecast as ModelForecast

/**
 * Created by alexandra.ferreira on 12/4/17.
 */

//Classes must be mapped from the data to the domain model

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        //In a single line, we can loop over the collection and return a new list with the converted
        // items. Kotlin provides a good set of functional operations over lists, which apply an
        // operation for all the items in a list and transform them in any way.
        return list.mapIndexed {  i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }

    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconURL(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }

    private fun generateIconURL(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"


}
package data

import domain.Command
import domain.Model
import java.text.DateFormat
import java.util.*

//As we are using two classes with the same name, we can give a specific name to one of them so
//that we don’t need to write the complete package:
import domain.Model.Forecast as ModelForecast

/**
 * Created by alexandra.ferreira on 12/4/17.
 */

//Classes must be mapped from the data to the domain model

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ResponseClasses.ForecastResult): Model.ForecastList {
        return Model.ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<ResponseClasses.Forecast>):
            List<Model.Forecast> {
        //In a single line, we can loop over the collection and return a new list with the converted
        // items. Kotlin provides a good set of functional operations over lists, which apply an
        // operation for all the items in a list and transform them in any way.
        return list.map { convertForecastItemToDomain(it) }

    }

    private fun convertForecastItemToDomain(forecast: ResponseClasses.Forecast): Model.Forecast {
        return Model.Forecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconURL(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconURL(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"


}
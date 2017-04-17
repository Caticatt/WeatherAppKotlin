package org.example.weatherappkotlin.domain.model

/**
 * Created by alexandra.ferreira on 17/4/17.
 */
class CityForecast (val map: MutableCollection<String, Any?>, val dailyforecast: List<DayForecast>){

    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, country: String, dailyForecast: List<DayForecast>) : this(HashMap(), dailyForecast)) {
        this._id = id
        this.city = city
        this.country = country
    }

}
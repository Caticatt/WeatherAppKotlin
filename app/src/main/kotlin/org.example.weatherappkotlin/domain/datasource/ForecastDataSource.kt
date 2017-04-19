package org.example.weatherappkotlin.domain.datasource

import org.example.weatherappkotlin.domain.datasource.ForecastProvider.Companion.DAY_IN_MILLIS
import org.example.weatherappkotlin.domain.model.ForecastList

/**
 * Created by alexandra.ferreira on 19/4/17.
 */

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

}
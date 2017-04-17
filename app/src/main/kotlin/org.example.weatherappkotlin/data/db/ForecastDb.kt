package org.example.weatherappkotlin.data.db

import org.example.weatherappkotlin.domain.mappers.ForecastDataMapper

/**
 * Created by alexandra.ferreira on 17/4/17.
 */

class ForecastDb(
        val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
        val dataMapper: DbDataPapper = DbDataMapper()) {

}
package domain

/**
 * Created by alexandra.ferreira on 12/4/17.
 */
class RequestForecastCommand(val zipCode: String) : Command<Model.ForecastList> {

    override fun execute(): Model.ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forescastRequest.execute())
    }
}
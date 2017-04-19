package org.example.weatherappkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import org.example.weatherappkotlin.R
import org.example.weatherappkotlin.domain.model.Forecast
import org.example.weatherappkotlin.domain.model.ForecastList
import org.example.weatherappkotlin.extensions.ctx
import java.text.DateFormat
import java.util.*
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.example.weatherappkotlin.extensions.toDateString


/**
 * Created by alexandra.ferreira on 11/4/17.
 */

//We need an adapter for the recycler too. The views used for RecyclerView adapter will be just
//TextViews and a simple list of texts that  we’ll create manually.

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //"with" is a useful function included in the standard Kotlin library. It basically receives an
        // object and an extension function as parameters, and makes the object execute the function.
        // This means that all the code we define inside the brackets acts as an extension function
        // of the object we specify in the first parameter, and we can use all its public functions and
        // properties.
        holder.bindForecast(weekForecast[position])

    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}
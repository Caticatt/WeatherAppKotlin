package org.example.weatherappkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //we define the variable and cast it to RecyclerView.
        //A LayoutManager is also specified, using the property naming instead of the setter.
        // A list will be enough for this layout, so a LinearLayoutManager will make it.
        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        loadForecast()

    }

    private fun loadForecast()  =doAsync{
        val result = RequestForecastCommand("94043").execute()
        uiThread {
            forecastList.adapter = ForecastListAdapter(result)
        }
    }

}



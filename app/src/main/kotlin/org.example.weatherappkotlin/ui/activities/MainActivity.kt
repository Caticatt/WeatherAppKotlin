package org.example.weatherappkotlin

import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import org.example.weatherappkotlin.R
import org.example.weatherappkotlin.domain.commands.RequestForecastCommand
import org.example.weatherappkotlin.extensions.DelegatesExt
import org.example.weatherappkotlin.ui.activities.DetailActivity
import org.example.weatherappkotlin.ui.activities.SettingsActivity
import org.example.weatherappkotlin.ui.adapters.ForecastListAdapter
import org.example.weatherappkotlin.ui.activities.ToolbarManager
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity(), ToolbarManager {

    val zipCode: Long by DelegatesExt.preference(this, SettingsActivity.ZIP_CODE,
            SettingsActivity.DEFAULT_ZIP)
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() = doAsync {
        val result = RequestForecastCommand(zipCode).execute()
        uiThread {
            val adapter = ForecastListAdapter(result) {
                startActivity<DetailActivity>(DetailActivity.ID to it.id,
                        DetailActivity.CITY_NAME to result.city)
            }

            forecastList.adapter = adapter
            toolbarTitle = "${result.city} (${result.country})"
        }
        
    }
}
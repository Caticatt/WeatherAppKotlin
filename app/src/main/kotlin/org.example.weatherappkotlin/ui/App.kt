package org.example.weatherappkotlin.ui

import android.app.Application
import org.example.weatherappkotlin.ui.utils.DelegatesExt

/**
 * Created by alexandra.ferreira on 17/4/17.
 */

class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}


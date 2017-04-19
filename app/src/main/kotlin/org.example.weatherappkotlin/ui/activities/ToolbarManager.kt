package org.example.weatherappkotlin.ui.activities

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toolbar
import org.example.weatherappkotlin.R
import org.example.weatherappkotlin.extensions.ctx
import org.example.weatherappkotlin.extensions.slideEnter
import org.example.weatherappkotlin.extensions.slideExit
import org.example.weatherappkotlin.ui.App
import org.example.weatherappkotlin.ui.activities.SettingsActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by alexandra.ferreira on 19/4/17.
 */
interface ToolbarManager {

    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings -> toolbar.ctx.startActivity<SettingsActivity>()
                else -> App.instance.toast("Unknown option")
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setOnClickListener { up() }
    }

    fun createUpDrawable() = with(DrawerArrowDrawable(toolbar.ctx)) {
        progress = 1f
        this
    }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }

}
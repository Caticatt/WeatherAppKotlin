package org.example.weatherappkotlin.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * Created by alexandra.ferreira on 17/4/17.
 */


// "Anko" provides a lot of extension functions to make Android coding simpler. It, for instance,
// includes a ctx property for activities and fragments, among. Making the forecast list clickable
// others, which returns the context,  but it lacks of the same property for views. It’s a good
// example of how to use extension properties.

val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}
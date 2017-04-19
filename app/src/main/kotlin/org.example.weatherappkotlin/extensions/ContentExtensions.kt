package org.example.weatherappkotlin.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by alexandra.ferreira on 19/4/17.
 */

fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)

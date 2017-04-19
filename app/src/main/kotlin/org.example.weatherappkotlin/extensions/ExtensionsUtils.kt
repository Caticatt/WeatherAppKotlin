package org.example.weatherappkotlin.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by alexandra.ferreira on 19/4/17.
 */

fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}
package org.example.weatherappkotlin.extensions

/**
 * Created by alexandra.ferreira on 18/4/17.
 */

fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()
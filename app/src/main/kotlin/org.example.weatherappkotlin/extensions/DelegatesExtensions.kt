package org.example.weatherappkotlin.extensions

import kotlin.reflect.KProperty

/**
 * Created by alexandra.ferreira on 17/4/17.
 */

object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T>{

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} " + "not initialized")
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw  IllegalStateException("${property.name}  already initialized")
    }


}
package org.example.weatherappkotlin.extensions

import android.content.Context
import android.view.View

/**
 * Created by alexandra.ferreira on 17/4/17.
 */


// "Anko" provides a lot of extension functions to make Android coding simpler. It, for instance,
// includes a ctx property for activities and fragments, among. Making the forecast list clickable
// others, which returns the context,  but it lacks of the same property for views. It’s a good
// example of how to use extension properties.

val View.ctx: Context
    get() = context
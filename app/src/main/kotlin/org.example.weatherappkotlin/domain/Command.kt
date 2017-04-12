package domain

import data.ResponseClasses

/**
 * Created by alexandra.ferreira on 12/4/17.
 */

//This class contains some commands in charge of performing the use cases of the app. These commands
//will execute an operation and return an object of the class specified in its generic type.
// It’s interesting to know that every function in Kotlin returns a value. By default, if nothing
//is specified, it will return an object of the Unit class. So if we want our Command to return nothing,
//we can specify Unit as its type. Interfaces in Kotlin are more powerful than Java (prior to Java 8),
// because they can contain code. The first command needs to request the forecast to the API and
// convert it to domain classes. This is the definition of the domain classes.

public interface Command<T> {

    fun execute(): T

}
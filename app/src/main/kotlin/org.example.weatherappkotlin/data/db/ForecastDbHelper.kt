package org.example.weatherappkotlin.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.example.weatherappkotlin.ui.App
import org.jetbrains.anko.db.*

/**
 * Created by alexandra.ferreira on 17/4/17.
 */
class ForecastDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx, ForecastDbHelper.DB_NAME, null,
        ForecastDbHelper.DB_VERSION) {
    companion object {

        val DB_NAME = "forescast.db"
        val DB_VERSION = 1

//The instance property uses a lazy delegate, which means the object won’t be created until it’s
// used. That way, if the database is never used, we don’t create unnecessary objects. The regular lazy
// delegate is blocking in order to prevent the creation of several instances from different threads. This
// only would happen if two threads try to access the instance at the same time, which is difficult but
// it could happen depending on the type of App you are implementing. But the regular lazydelegate
// is thread safe.
        val instance by lazy { ForecastDbHelper() }

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        db?.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //fun SqlType.plus(m: SqlTypeModifier): SqlType {
        //  return SqlTypeImpl(name, if (modifier == null) m.toString()
        //else "$modifier $m")

        db?.dropTable(CityForecastTable.NAME, true)
        db?.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }
}



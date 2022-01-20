package com.example.roomdb_rayya_10.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Series::class],
    version = 1
)
abstract class SeriesDb : RoomDatabase(){

    abstract fun SeriesDao() : SeriesDao

    companion object {

        @Volatile private var instance : SeriesDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SeriesDb::class.java,
            "series12345.db"
        ).build()

    }
}
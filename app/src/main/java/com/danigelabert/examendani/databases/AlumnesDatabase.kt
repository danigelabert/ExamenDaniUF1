package com.danigelabert.examendani.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.danigelabert.examendani.model.Alumnes


@Database(
    entities = [Alumnes::class],
    version = 1,
    exportSchema = false
)


abstract class AlumnesDatabase  : RoomDatabase(){
    abstract fun alumnesDao() : AlumnesDao

    companion object {

        @Volatile
        private var INSTANCE: AlumnesDatabase? = null

        fun getDatabase(context: Context): AlumnesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AlumnesDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AlumnesDatabase::class.java,
                "alumnes_database"
            )
                .build()
        }
    }
}
package com.example.stockholmtoromev2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized

@Database(entities = arrayOf(Qindex::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val qindex : Qindex

    companion object {

        @Volatile
        var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            kotlin.synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "qIndex_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
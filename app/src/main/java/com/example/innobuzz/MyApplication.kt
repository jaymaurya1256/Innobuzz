package com.example.innobuzz

import android.app.Application
import androidx.room.Room
import com.example.innobuzz.database.Database

class MyApplication : Application() {
    companion object {
        lateinit var database: Database
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            "my_database"
        ).build()
    }
}
package com.example.innobuzz.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Posts::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun dao(): Dao
}
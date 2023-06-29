package com.example.innobuzz.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class Table (
        @PrimaryKey val id: Int,
        val title: String,
        val body: String,
        val userId: Int
        )
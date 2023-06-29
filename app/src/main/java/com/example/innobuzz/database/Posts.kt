package com.example.innobuzz.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Posts (
        var title: String,
        var body: String,
        @PrimaryKey var id: Int,
        var userId: Int
        )
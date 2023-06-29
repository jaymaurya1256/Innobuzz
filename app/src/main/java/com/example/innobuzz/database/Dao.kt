package com.example.innobuzz.database

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import com.example.innobuzz.network.entity.Post

@Dao
interface Dao {

    @Insert
    suspend fun insertData(posts: List<Post>)

    @Query("Select * from post where id == :id")
    suspend fun getDetails(id: Int): Table
}
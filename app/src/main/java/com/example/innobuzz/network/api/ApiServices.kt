package com.example.innobuzz.network.api

import com.example.innobuzz.network.entity.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}


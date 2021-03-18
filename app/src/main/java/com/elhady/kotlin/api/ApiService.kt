package com.elhady.kotlin.api

import com.elhady.kotlin.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts/1")
    suspend fun getPosts(): List<Post>
}
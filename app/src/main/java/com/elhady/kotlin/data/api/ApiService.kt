package com.elhady.kotlin.data.api

import com.elhady.kotlin.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
package com.elhady.kotlin.api

import com.elhady.kotlin.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts/1")
    suspend fun getPosts() : Response<Post>
}
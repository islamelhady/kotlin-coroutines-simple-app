package com.elhady.kotlin.repository

import com.elhady.kotlin.api.RetrofitBuilder
import com.elhady.kotlin.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post>{
        return RetrofitBuilder.api.getPosts()
    }
}
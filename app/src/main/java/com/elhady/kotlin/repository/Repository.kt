package com.elhady.kotlin.repository

import com.elhady.kotlin.api.RetrofitInstance
import com.elhady.kotlin.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post>{
        return RetrofitInstance.api.getPosts()
    }
}
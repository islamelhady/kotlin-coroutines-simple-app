package com.elhady.kotlin.data.repository

import com.elhady.kotlin.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getPost() = apiHelper.getPosts()
}
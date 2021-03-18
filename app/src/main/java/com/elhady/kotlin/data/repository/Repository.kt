package com.elhady.kotlin.data.repository

import com.elhady.kotlin.data.api.ApiHelper

class Repository(private val apiHelper: ApiHelper) {

    suspend fun getPost() = apiHelper.getPosts()
}
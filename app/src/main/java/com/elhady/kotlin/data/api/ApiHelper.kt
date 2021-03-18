package com.elhady.kotlin.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPosts() = apiService.getPosts()
}
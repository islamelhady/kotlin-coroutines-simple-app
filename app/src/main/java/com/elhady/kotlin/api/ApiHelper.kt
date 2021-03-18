package com.elhady.kotlin.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPosts() = apiService.getPosts()
}
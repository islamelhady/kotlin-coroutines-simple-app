package com.elhady.kotlin.model

data class Post(
    var userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
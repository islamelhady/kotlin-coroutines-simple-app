package com.elhady.kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elhady.kotlin.model.Post
import com.elhady.kotlin.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()


    fun getPostList() : MutableLiveData<Response<Post>> {
        return myResponse
    }


    fun getPost() {
        // to lunch kotlin coroutine
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
}
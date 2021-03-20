package com.elhady.kotlin.ui.main.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.elhady.kotlin.R
import com.elhady.kotlin.data.model.Post
import com.elhady.kotlin.data.repository.MainRepository
import com.elhady.kotlin.util.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getPosts() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getPost()))

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    companion object {
        private const val POSTS_KEY = "Posts"
        fun createArguments(post: Post): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(POSTS_KEY, post)
            return bundle
        }
    }
}
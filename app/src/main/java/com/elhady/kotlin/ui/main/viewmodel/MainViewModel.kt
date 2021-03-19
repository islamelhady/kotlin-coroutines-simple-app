package com.elhady.kotlin.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
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
}
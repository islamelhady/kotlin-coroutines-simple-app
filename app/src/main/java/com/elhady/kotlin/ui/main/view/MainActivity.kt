package com.elhady.kotlin.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.elhady.kotlin.R
import com.elhady.kotlin.data.repository.MainRepository
import com.elhady.kotlin.ui.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModelvat


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = MainRepository()
        val viewModelFactory = MainViewModel(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPosts()

        observeData()



    }

    private fun observeData() {
        var textView : TextView = findViewById(R.id.textView)
        viewModel.getPostList().observe(this, Observer { response ->
            if (response.isSuccessful) {
                // ? after the type to indicate that a variable can be null
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.id.toString())
                textView.text = response.body()?.toString()
                Log.d("Response", response.body()?.title!!)
                Log.d("Response", response.body()?.body!!)
            } else {
                Log.d("Response", response.errorBody().toString())
                textView.text = response.code().toString()
            }
        })

    }
}
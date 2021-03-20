package com.elhady.kotlin.ui.main.view.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhady.kotlin.R
import com.elhady.kotlin.data.api.ApiHelper
import com.elhady.kotlin.data.api.RetrofitBuilder
import com.elhady.kotlin.data.model.Post
import com.elhady.kotlin.ui.base.ViewModelFactory
import com.elhady.kotlin.ui.main.adapter.MainAdapter
import com.elhady.kotlin.ui.main.viewmodel.MainViewModel
import com.elhady.kotlin.ui.main.viewmodel.MainViewModel.Companion.createArguments
import com.elhady.kotlin.util.Status.SUCCESS
import com.elhady.kotlin.util.Status.ERROR
import com.elhady.kotlin.util.Status.LOADING
import kotlinx.android.synthetic.main.fragment_post_list.*


class PostListFragment : Fragment() , MainAdapter.OnPostItemClickListener {


    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupObservers()
        setupUI()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getPosts().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { posts -> retrieveList(posts) }
                    }
                    ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MainAdapter(arrayListOf(),this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun retrieveList(posts: List<Post>) {
        adapter.apply {
            addUsers(posts)
            notifyDataSetChanged()
        }
    }

    override fun onItemClick(posts: Post, position: Int) {
        Toast.makeText(activity, posts.title, Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.postDetailsFragment,createArguments(posts))
    }
}
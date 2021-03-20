package com.elhady.kotlin.ui.main.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elhady.kotlin.R
import com.elhady.kotlin.data.model.Post
import com.elhady.kotlin.databinding.FragmentPostDetailsBinding


class PostDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPostDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        return binding.apply {
            post = (requireArguments().get(getString(R.string.posts_key))) as Post
        }.root
    }
}
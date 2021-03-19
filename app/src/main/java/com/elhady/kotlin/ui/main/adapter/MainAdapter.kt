package com.elhady.kotlin.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elhady.kotlin.R
import com.elhady.kotlin.data.model.Post
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private val posts: ArrayList<Post>) :
    RecyclerView.Adapter<MainAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(posts: Post) {
            itemView.apply {
                textViewTitle.text = posts.title
                textViewBody.text = posts.body
                userId.text = posts.userId.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size


    fun addUsers(posts: List<Post>) {
        this.posts.apply {
            clear()
            addAll(posts)
        }
    }
}
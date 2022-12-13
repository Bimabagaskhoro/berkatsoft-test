package com.bimabagaskhoro.testberkatsoft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.testberkatsoft.R
import com.bimabagaskhoro.testberkatsoft.databinding.ItemMovieLargeBinding
import com.bimabagaskhoro.testberkatsoft.domain.model.ItemMovie
import com.bumptech.glide.Glide

class MovieAdapterLarge  : RecyclerView.Adapter<MovieAdapterLarge.ViewHolder>() {
    private var listData = ArrayList<ItemMovie>()
    var onItemClicked: ((ItemMovie) -> Unit)? = null

    fun setData(newListData: List<ItemMovie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.item_movie_large, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMovieLargeBinding.bind(itemView)
        fun bind(data: ItemMovie) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(LINK_IMAGE + data.posterPath)
                    .into(imageMovieLarge)
                itemView.setOnClickListener { onItemClicked?.invoke(data) }
            }
        }
    }

    companion object {
        const val LINK_IMAGE = "https://image.tmdb.org/t/p/w500"
    }
}
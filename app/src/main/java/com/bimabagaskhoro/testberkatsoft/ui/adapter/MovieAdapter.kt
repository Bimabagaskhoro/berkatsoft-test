package com.bimabagaskhoro.testberkatsoft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.testberkatsoft.R
import com.bimabagaskhoro.testberkatsoft.databinding.ItemMoviesBinding
import com.bimabagaskhoro.testberkatsoft.domain.model.ItemMovie
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var listData = ArrayList<ItemMovie>()
    var onItemClicked: ((ItemMovie) -> Unit)? = null

    fun setData(newListData: List<ItemMovie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMoviesBinding.bind(itemView)
        fun bind(data: ItemMovie) {
            binding.apply {
                tvTittle.text = data.title
                Glide.with(itemView.context)
                    .load(LINK_IMAGE + data.posterPath)
                    .into(imageMovie)
                itemView.setOnClickListener { onItemClicked?.invoke(data) }
            }

        }
    }

    companion object {
        const val LINK_IMAGE = "https://image.tmdb.org/t/p/w500"
    }
}
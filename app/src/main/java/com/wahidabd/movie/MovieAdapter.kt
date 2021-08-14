package com.wahidabd.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wahidabd.movie.databinding.ItemListBinding
import com.wahidabd.movie.model.DataMovie
import com.wahidabd.movie.util.loadImage

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var onItemClick: OnItemClick

    private val list = ArrayList<DataMovie>()
    fun setList(list: List<DataMovie>){
        this.list.clear()
        this.list.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataMovie){
            with(binding){
                image.loadImage(data.image)
                title.text = data.title

                cardView.setOnClickListener {
                    onItemClick.onItemClicked(data)
                }
            }
        }
    }

    fun setOnClick(onItemClick: OnItemClick){
        this.onItemClick = onItemClick
    }

    interface OnItemClick{
        fun onItemClicked(data: DataMovie)
    }
}
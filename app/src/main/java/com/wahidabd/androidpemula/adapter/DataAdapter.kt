package com.wahidabd.androidpemula.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahidabd.androidpemula.databinding.ListItemsBinding
import com.wahidabd.androidpemula.model.Entity

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private lateinit var onItemClick: OnItemClick
    private var list = ArrayList<Entity>()

    fun setData(data: List<Entity>){
        list.clear()
        list.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ListItemsBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(data: Entity){
            with(binding){
                Glide.with(binding.root)
                    .load(data.img)
                    .into(img)

                tvTitle.text = data.title
                tvEstimasi.text = "Level: ${data.estimasi}"
                tvLevel.text = "Estimasi: ${data.level}"

                cardItem.setOnClickListener {
                    onItemClick.onItemClicked(data)
                }
            }
        }
    }

    fun setOnItemClick(onItemClick: OnItemClick){
        this.onItemClick = onItemClick
    }

    interface OnItemClick{
        fun onItemClicked(data: Entity)
    }
}
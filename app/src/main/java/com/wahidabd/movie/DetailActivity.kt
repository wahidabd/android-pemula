package com.wahidabd.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wahidabd.movie.databinding.ActivityDetailBinding
import com.wahidabd.movie.model.DataMovie
import com.wahidabd.movie.util.loadImage

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<DataMovie>(DATA)

        with(binding){
            data?.let { image.loadImage(it.image) }
            title.text = data?.title
            overview.text = data?.overview
        }

    }

    companion object{
        const val DATA = "data"
    }
}
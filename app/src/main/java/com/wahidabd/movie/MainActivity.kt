package com.wahidabd.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wahidabd.movie.databinding.ActivityMainBinding
import com.wahidabd.movie.model.DataMovie
import com.wahidabd.movie.util.DataDummy

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieAdapter()
        val data = DataDummy.getAllMovie()

        adapter.setList(data)
        binding.rvMovie.adapter = adapter
        binding.rvMovie.layoutManager = LinearLayoutManager(this)

        adapter.setOnClick(object : MovieAdapter.OnItemClick{
            override fun onItemClicked(data: DataMovie) {
                startActivity(Intent(
                    this@MainActivity, DetailActivity::class.java)
                    .putExtra(DetailActivity.DATA, data))
            }
        })
    }
}
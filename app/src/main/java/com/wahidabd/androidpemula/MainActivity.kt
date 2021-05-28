package com.wahidabd.androidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wahidabd.androidpemula.databinding.ActivityMainBinding
import com.wahidabd.androidpemula.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
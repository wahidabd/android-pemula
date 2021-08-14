package com.wahidabd.movie.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide.with(this)
        .load("https://image.tmdb.org/t/p/w500$url")
        .into(this)
}
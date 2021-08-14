package com.wahidabd.movie.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataMovie(
    val id: Int,
    val title: String,
    val overview: String,
    val image: String
): Parcelable
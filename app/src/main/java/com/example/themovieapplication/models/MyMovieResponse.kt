package com.example.themovieapplication.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class MyMovieResponse(
    @SerializedName("results")
    val movies  :  List<MyMovies>

)

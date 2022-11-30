package com.example.themovieapplication.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class MyMovieResponse(
    @SerializedName(RESULTS)
    val moviesList  :  List<MyMovies>

){
    companion object{
        const val RESULTS ="results"
    }
}

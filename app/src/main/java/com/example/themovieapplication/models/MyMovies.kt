package com.example.themovieapplication.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class MyMovies(


    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String ?,
    @SerializedName("poster_path")
    val poster : String ?,
    @SerializedName("release_date")
    val release : String ?


)
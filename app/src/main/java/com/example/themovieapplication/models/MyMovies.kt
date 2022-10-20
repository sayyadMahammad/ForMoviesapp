package com.example.themovieapplication.models


import com.google.gson.annotations.SerializedName



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
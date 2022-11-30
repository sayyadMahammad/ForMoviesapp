package com.example.themovieapplication.models


import com.google.gson.annotations.SerializedName



data class MyMovies(


    @SerializedName(ID)
    val id : String ?,
    @SerializedName(TITLE)
    val title : String ?,
    @SerializedName(POSTER_PATH)
    val poster : String ?,
    @SerializedName(RELEASE_DATE)
    val release : String ? ,

//    @SerializedName(mode)
//    val title : String ?,
////    @SerializedName("poster_path")
////    val poster : String ?,
//    @SerializedName(dateT)
//    val release : String ?


){
    companion object{
        const val ID = "id"
        const val TITLE="title"
        const val POSTER_PATH="poster_path"
        const val RELEASE_DATE = "release_date"
        const val dateT = "dateOfTransaction"
        const val mode="modeOfPayment"
    }
}
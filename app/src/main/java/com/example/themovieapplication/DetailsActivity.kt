package com.example.themovieapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {
    lateinit var imagePoster : ImageView
    lateinit var posterTitle : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        imagePoster=findViewById(R.id.imagePoster)
        posterTitle=findViewById(R.id.posterTitle)
        val bundle: Bundle? =intent.extras
       val movieTitle = bundle?.get(movieTitle)
        val imageUrl = bundle?.get(moviePoster)
        posterTitle.text=movieTitle.toString()
        Glide.with(this).load(ImageBase+imageUrl).into(imagePoster)

    }
}
package com.example.themovieapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    lateinit var imagePoster : ImageView
    lateinit var posterTitle : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        imagePoster=findViewById(R.id.imagePoster)
        posterTitle=findViewById(R.id.posterTitle)

    }
}
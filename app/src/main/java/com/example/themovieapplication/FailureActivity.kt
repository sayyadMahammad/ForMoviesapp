package com.example.themovieapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FailureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failure)
        val failureText = findViewById<TextView>(R.id.failureText)
        failureText.text=intent.getStringExtra("message")
    }
}
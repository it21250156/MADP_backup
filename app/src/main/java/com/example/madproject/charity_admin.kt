package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class charity_admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charity_admin)

        var buttonten = findViewById<Button>(R.id.button10)
        buttonten.setOnClickListener {
            val intent1 = Intent (this, edu_charity_admin::class.java)
            startActivity(intent1)
        }
    }
}
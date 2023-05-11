package com.example.madproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Charity_admin : AppCompatActivity() {

    private  lateinit var button10:Button
    private lateinit var button11:Button
    private lateinit var button13:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charity_admin)

        @SuppressLint("MissingInflatedId")



        button10 = findViewById<Button>(R.id.button10)
        button11 = findViewById(R.id.button11)
        button13 = findViewById(R.id.button13)


        button10.setOnClickListener {
            val intent1 = Intent (this, Edu_charity_admin::class.java)
            startActivity(intent1)
        }

        //button11.setOnClickListener {
           // val intent1 = Intent (this, Edu_charity_admin::class.java)
            //startActivity(intent)
        //}

        //button13.setOnClickListener {
         //   val intent1 = Intent (this, Edu_charity_admin::class.java)
          //  startActivity(intent)
      //  }
    }



}
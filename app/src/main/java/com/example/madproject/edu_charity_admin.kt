package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class edu_charity_admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edu_charity_admin)

//        var buttontwenty = findViewById<Button>(R.id.button20)
//        buttontwenty.setOnClickListener {
//            val intent2 = Intent(this,charity_admin::class.java)
//            startActivity(intent2)
//
//        }
//
//        var buttonfifthteen = findViewById<Button>(R.id.button15)
//        buttonfifthteen.setOnClickListener {
//            val intent1 = Intent (this, add_new_chariti::class.java)
//            startActivity(intent1)
//        }
//
//
//        var buttonsixteen= findViewById<Button>(R.id.button16)
//        buttonsixteen.setOnClickListener {
//            val intent1 = Intent (this, update_charity::class.java)
//            startActivity(intent1)
//        }
    }

    fun createCharity(view: View){
        val intent = Intent(this,add_new_chariti::class.java)
        startActivity(intent)
    }

}
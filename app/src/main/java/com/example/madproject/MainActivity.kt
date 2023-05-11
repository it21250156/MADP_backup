package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.example.madproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun registeredCustomerHome(view: View){
        val intent = Intent(this,CustomerMain::class.java)
        startActivity(intent)
    }

    fun loginInter(view: View){
        val intent = Intent(this,LoginActivity2::class.java)
        startActivity(intent)
    }

    fun signupInter(view: View){
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    fun adminHome(view: View){
        val intent = Intent(this, AdminHome::class.java)
        startActivity(intent)
    }

    fun createCharity(view: View){
        val intent = Intent(this, Add_new_chariti::class.java)
        startActivity(intent)
    }






}
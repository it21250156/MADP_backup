package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class AdminHome : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        val adminLogoutBtn: Button = findViewById(R.id.btn_admin_logout)
        adminLogoutBtn.setOnClickListener {
            performLogout()
        }
    }


    fun adminPosts(view: View){
        val intent = Intent(this, AdminPostListActivity::class.java)
        startActivity(intent)
    }

    fun adminCharity(view: View){
        val intent = Intent(this,edu_charity_admin::class.java)
        startActivity(intent)
    }

    private fun performLogout() {
        //logout from firebase
        auth.signOut()

        //back to login page
        val intent = Intent(this, LoginActivity2::class.java)
        startActivity(intent)

        //to prevent user from going back
        finish()

    }

}
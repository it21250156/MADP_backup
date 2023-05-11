package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AdminPostListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_post_list)
    }

    fun addPost(view: View){
        val intent = Intent(this, AdminPostForm::class.java)
        startActivity(intent)
    }
}
package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AdminPostForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_post_form)
    }

    fun backToPosts(view: View){
        val intent = Intent(this,AdminPostListActivity::class.java)
        startActivity(intent)
    }
}
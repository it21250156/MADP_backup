package com.example.madproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        auth = Firebase.auth

        val registertxt: TextView = findViewById(R.id.tv_register_now)

        registertxt.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        val loginBtn: Button = findViewById(R.id.btn_login)

        loginBtn.setOnClickListener {
            performLogin()
        }
        //login now
    }

    private fun performLogin() {
        //get user inputs
        val email: EditText = findViewById(R.id.edtText_login_email)
        val password: EditText = findViewById(R.id.edtText_login_password)

        //null checks on inputs
        if(email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val emailInput = email.text.toString()
        val passwordInput = password.text.toString()

        if(emailInput=="admin@gmail.com" || passwordInput=="admin1234"){
            val intent = Intent(this,AdminHome::class.java)
            startActivity(intent)
        } else{
            auth.signInWithEmailAndPassword(emailInput, passwordInput)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success. navigate to user home
                        val intent = Intent(this,CustomerMain::class.java)
                        startActivity(intent)

                        Toast.makeText(
                            baseContext,
                            "Success.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
                .addOnFailureListener{
                    Toast.makeText(
                        baseContext,
                        "Authentication failed. ${it.localizedMessage}",
                        Toast.LENGTH_SHORT,
                    ).show()
                }

        }


    }

}
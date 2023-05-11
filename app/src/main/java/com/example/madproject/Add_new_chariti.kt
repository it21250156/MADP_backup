package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Add_new_chariti : AppCompatActivity() {
    private lateinit var charityname: EditText
  //  private lateinit var charitycategory: Spinner
    private lateinit var charityaddress: EditText
    private lateinit var charitycontact: EditText
    private lateinit var charityemail: EditText
    private lateinit var charitydescription: EditText
    private lateinit var btnaddcharity: Button
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_chariti)

        charityname = findViewById(R.id.edtText_admin_CharName)
        //charitycategory = findViewById(R.id.spnr_chat_cate)
        charityaddress = findViewById(R.id.edtText_admin_char_address)
        charitycontact = findViewById(R.id.edtText_admin_char_contact)
        charityemail = findViewById(R.id.edtText_admin_char_email)
        charitydescription = findViewById(R.id.edtText_admin_char_description)
        btnaddcharity = findViewById(R.id.btn_btn_admin_add_char)

        dbRef = FirebaseDatabase.getInstance().getReference("New charity")

        btnaddcharity.setOnClickListener {
            addcharitidata()
        }
    }

    private fun addcharitidata() {
        // getting values
        val charityName = charityname.text.toString()
       // val charityCategory = charitycategory.selectedItem.toString()
        val charityAddress = charityaddress.text.toString()
        val charityContact = charitycontact.text.toString()
        val charityEmail = charityemail.text.toString()
        val charityDescription = charitydescription.text.toString()

        if (charityName.isEmpty()) {
            charityname.error = "please enter name"
        }
//        if (charityCategory.isEmpty()) {
//            // you can use setError method for Spinner instead of error property
//            (charitycategory.selectedView as TextView).error = "please select category"
//        }
        if (charityAddress.isEmpty()) {
            charityaddress.error = "please enter address"
        }
        if (charityContact.isEmpty()) {
            charitycontact.error = "please enter contact"
        }
        if (charityEmail.isEmpty()) {
            charityemail.error = "please enter email "
        }
        if (charityDescription.isEmpty()) {
            charitydescription.error = "please enter description "
        }

        val charityID = dbRef.push().key!!

        val charity = CharityModel(
            charityID,
            charityName,
            //charityCategory,
            charityAddress,
            charityContact,
            charityEmail,
            charityDescription
        )

        dbRef.child(charityID).setValue(charity)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                charityname.text.clear()
               // charitycategory.setSelection(0)
                charityaddress.text.clear()
                charitycontact.text.clear()
                charityemail.text.clear()
                charitydescription.text.clear()
            }
            .addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }

    fun backToCharities(view: View) {
        val intent = Intent(this, Edu_charity_admin::class.java)
        startActivity(intent)
    }
}

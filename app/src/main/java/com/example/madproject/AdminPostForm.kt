package com.example.madproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AdminPostForm : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var cName: EditText
    private lateinit var description: EditText
    private lateinit var btnAdd: Button

    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_post_form)

        title = findViewById(R.id.edtText_admin_postTitle)
        cName = findViewById(R.id.edtText_admin_postChaName)
        description = findViewById(R.id.edtText_admin_postDes)
        btnAdd = findViewById(R.id.btn_btn_admin_add_post) // Add this line to initialize btnAddCategory

        dbRef = FirebaseDatabase.getInstance().getReference("adminfo")

        btnAdd.setOnClickListener{
            saveformData()
        }

    }

    private fun saveformData(){

//getting values

        val title2 = title.text.toString()
        val cname = cName.text.toString()
        val descript = description.text.toString()

        if(title2.isEmpty()){
            title.error = "Please enter category name"
        }
        if(cname.isEmpty()){
            cName.error = "Please enter description"
        }
        if(descript.isEmpty()){
            description.error = "Please enter Amount"
        }

        val titleid= dbRef.push().key!!

        val expence = admipostmodel(titleid,title2,cname,descript)

        dbRef.child(titleid).setValue(expence).addOnCompleteListener{
            Toast.makeText(this,"Data inserted", Toast.LENGTH_SHORT).show()

            title.text.clear()
            cName.text.clear()
            description.text.clear()

        }.addOnFailureListener { err ->
            Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_SHORT).show()
        }

    }
}
//    fun backToPosts(view: View){
//        val intent = Intent(this,AdminPostListActivity::class.java)
//        startActivity(intent)
//    }


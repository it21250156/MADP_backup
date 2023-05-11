package com.example.madproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class selected_admin_charity : AppCompatActivity() {

    private lateinit var charityId: TextView
    private lateinit var charityname: TextView
    private lateinit var charityaddress: TextView
    private lateinit var charitycontact: TextView
    private lateinit var charityemail: TextView
    private lateinit var charitydescription: TextView
    private lateinit var btn_edu_update:Button
    private lateinit var btn_edu_delete:Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_admin_charity)

//        donateBtn.setOnClickListener {
//            val fragment = CardDetails()
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.fl_nav, fragment)?.commit()
//        }
//
//        backToCharitiCate.setOnClickListener {
//            val fragment = Educational_charity_list()
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.fl_nav, fragment)?.commit()
//        }

        initView()

        setValuesToViews()

        btn_edu_update.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("charityId").toString(),
                intent.getStringExtra("charityName").toString()
            )
        }

        btn_edu_delete.setOnClickListener{
            deleteRecord(
                intent.getStringExtra("charityId").toString()
            )
        }

    }

    private fun deleteRecord(rId: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("New charity").child(rId)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Charity deleted", Toast.LENGTH_LONG).show()
            finish() // Close this activity and return to the previous activity
        }.addOnFailureListener { error ->
            Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun initView() {
        charityId = findViewById(R.id.charityId)
        charityname = findViewById(R.id.charityName)
        charityaddress = findViewById(R.id.charitiaddress)
        charitycontact = findViewById(R.id.charityContact)
        charityemail = findViewById(R.id.charityEmail)
        charitydescription = findViewById(R.id.charityDescription)
        btn_edu_update = findViewById(R.id.btn_edu_update)
        btn_edu_delete = findViewById(R.id.btn_edu_delete)



//        val args = arguments
//        if (args != null) {
//            charityId.text = args.getString("Charity Id")
//            charityname.text = args.getString("Charity Name")
//            charityaddress.text = args.getString("Charity Address")
//            charitycontact.text = args.getString("Charity Contact")
//            charityemail.text = args.getString("Charity Email")
//            charitydescription.text = args.getString("Charity Description")
//        }
    }

    private fun setValuesToViews() {
        charityId.text = intent.getStringExtra("charityId")
        charityname.text = intent.getStringExtra("charityName")
        charityaddress.text = intent.getStringExtra("charityAddress")
        charitycontact.text = intent.getStringExtra("charityContact")
        charityemail.text = intent.getStringExtra("charityEmail")
        charitydescription.text = intent.getStringExtra("charityDescription")
    }

    private fun openUpdateDialog(
        charityId: String,
        charityName:String
    ){
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView =  inflater.inflate(R.layout.activity_update_charity,null)

        mDialog.setView(mDialogView)

        val charityName = mDialogView.findViewById<EditText>(R.id.etcharityName)
        val charityAddress = mDialogView.findViewById<EditText>(R.id.etcharityAddress)
        val charityContact = mDialogView.findViewById<EditText>(R.id.etcharityContact)
        val charityEmail = mDialogView.findViewById<EditText>(R.id.etcharityEmail)
        val charityDescription = mDialogView.findViewById<EditText>(R.id.etcharityDescription)

        val btn_edu_update = mDialogView.findViewById<Button>(R.id.btn_edu_submit)

        charityName.setText(intent.getStringExtra("charityName").toString())
        charityAddress.setText(intent.getStringExtra("charityAddress").toString())
        charityContact.setText(intent.getStringExtra("charityContact").toString())
        charityEmail.setText(intent.getStringExtra("charityEmail").toString())
        charityDescription.setText(intent.getStringExtra("charityDescription").toString())

        mDialog.setTitle("Updating $charityName Record")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btn_edu_update.setOnClickListener{
            updatecharityData(
                charityId,
                charityName.text.toString(),
                charityAddress.text.toString(),
                charityContact.text.toString(),
                charityEmail.text.toString(),
                charityDescription.text.toString(),

            )
            Toast.makeText(applicationContext,"Employee Data Updated", Toast.LENGTH_LONG).show()

            //we are adding updated data to our textviews
            charityname.text =  charityName.text.toString()
            charityaddress.text =  charityAddress.text.toString()
            charitycontact.text =  charityContact.text.toString()
            charityemail.text =  charityEmail.text.toString()
            charitydescription.text =  charityDescription.text.toString()

            alertDialog.dismiss()
        }

    }

    private fun updatecharityData(
        id:String,
        name:String,
        address:String,
        contact:String,
        email:String,
        description:String
    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("New charity").child(id)
        val charitiInfo = CharityModel(id, name, address, contact, email, description)
        dbRef.setValue(charitiInfo)
    }

}

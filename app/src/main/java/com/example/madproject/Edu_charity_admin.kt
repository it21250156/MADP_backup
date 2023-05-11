package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Edu_charity_admin : AppCompatActivity() {

    private lateinit var  charityRecyclerView : RecyclerView
    private lateinit var EducationList : ArrayList<CharityModel>
    private lateinit var dbRef : DatabaseReference
//
//    private lateinit var  charityRecyclerView: RecyclerView
//    private lateinit var tvLoadingData:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edu_charity_admin)

    charityRecyclerView = findViewById(R.id.rv_edu_chariti_admin_list)
    charityRecyclerView.layoutManager = LinearLayoutManager(this)

    charityRecyclerView.setHasFixedSize(true)

    EducationList = arrayListOf<CharityModel>()

    getcharitydata()

//    backBtn.setOnClickListener {
//        val fragment = Charities()
//        val transaction = fragmentManager?.beginTransaction()
//        transaction?.replace(R.id.fl_nav,fragment)?.commit()
//    }

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

    private fun  getcharitydata() {
        charityRecyclerView.visibility = View.GONE

        dbRef = FirebaseDatabase.getInstance().getReference("New charity")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                EducationList.clear()
                if (snapshot.exists()){
                    for(charitySnap in snapshot.children) {
                        val charityData = charitySnap.getValue(CharityModel::class.java)
                        EducationList.add(charityData!!)
                    }
                    val mAdapter = Edu_charity_admin_adpter(EducationList)
                    charityRecyclerView.adapter = mAdapter

                     mAdapter.setOnItemClickListener(object : Edu_charity_admin_adpter.onItemClickListener{

                        override fun onItemClick(position: Int){
                            val intent = Intent(this@Edu_charity_admin, selected_admin_charity::class.java)

                            //put extras
                            intent.putExtra("charityId",EducationList[position].charityID)
                            intent.putExtra("charityName",EducationList[position].charityName)
                            intent.putExtra("charityAddress",EducationList[position].charityAddress)
                            intent.putExtra("charityContact",EducationList[position].charityContact)
                            intent.putExtra("charityEmail",EducationList[position].charityEmail)
                            intent.putExtra("charityDescription",EducationList[position].charityDescription)

                            startActivity(intent)

                        }


                    })

                    charityRecyclerView.visibility = View.VISIBLE

                }

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }




    fun createCharity(view: View){
        val intent = Intent(this,Add_new_chariti::class.java)
        startActivity(intent)
    }



}
//package com.example.madproject
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.google.firebase.database.*
//
//class Educational_charity_admin_list : Fragment() {
//
//    private lateinit var  charityRecyclerView : RecyclerView
//    private lateinit var EducationList : ArrayList<CharityModel>
//    private lateinit var dbRef : DatabaseReference
//
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_educational_charity_admin_list, container, false)
//        val backBtn : Button = view.findViewById(R.id.btn_edu_back)
//
//
//
//        charityRecyclerView = view.findViewById(R.id.rv_edu_chariti_admin_list)
//        charityRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        charityRecyclerView.setHasFixedSize(true)
//
//        EducationList = arrayListOf<CharityModel>()
//
//        getcharitydata()
//
//        backBtn.setOnClickListener {
//            val fragment = Charities()
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.fl_nav,fragment)?.commit()
//        }
//
//
//
//        return view
//    }
//    private fun  getcharitydata() {
//        charityRecyclerView.visibility = View.GONE
//
//        dbRef = FirebaseDatabase.getInstance().getReference("New charity")
//
//        dbRef.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                EducationList.clear()
//                if (snapshot.exists()){
//                    for(charitySnap in snapshot.children) {
//                        val charityData = charitySnap.getValue(CharityModel::class.java)
//                        EducationList.add(charityData!!)
//                    }
//                    val mAdapter = Edu_charity_admin_adpter(EducationList)
//                    charityRecyclerView.adapter = mAdapter
//
////                    mAdapter.setOnItemClickListener(object : Edu_charity_admin_adpter.onItemClickListener{
////
////                        override fun onItemClick(position: Int){
////                            val intent = Intent(requireContext(), selected_admin_charity::class.java)
////
////                            //put extras
////                            intent.putExtra("charityId",EducationList[position].charityID)
////                            intent.putExtra("charityName",EducationList[position].charityName)
////                            intent.putExtra("charityAddress",EducationList[position].charityAddress)
////                            intent.putExtra("charityContact",EducationList[position].charityContact)
////                            intent.putExtra("charityEmail",EducationList[position].charityEmail)
////                            intent.putExtra("charityDescription",EducationList[position].charityDescription)
////
////                            startActivity(intent)
////
////                        }
////
////
////                    })
//
//                    charityRecyclerView.visibility = View.VISIBLE
//
//                }
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//        })
//    }
//
//
//
//}
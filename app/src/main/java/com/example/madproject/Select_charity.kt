//package com.example.madproject
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//
//class Select_charity : Fragment() {
//
//    private lateinit var charityId: TextView
//    private lateinit var charityname: TextView
//    private lateinit var charityaddress: TextView
//    private lateinit var charitycontact: TextView
//    private lateinit var charityemail: TextView
//    private lateinit var charitydescription: TextView
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_select_charity, container, false)
//        val donateBtn: Button = view.findViewById(R.id.btn_donate)
//        val backToCharitiCate: Button = view.findViewById(R.id.btn_backto_chari_list)
//
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
//
//        initView(view)
//        return view
//    }
//
//    private fun initView(view: View) {
//        charityId = view.findViewById(R.id.charityId)
//        charityname = view.findViewById(R.id.charityName)
//        charityaddress = view.findViewById(R.id.charityaddress)
//        charitycontact = view.findViewById(R.id.charitycontact)
//        charityemail = view.findViewById(R.id.charityemail)
//        charitydescription = view.findViewById(R.id.charitydescription)
//
////        val args = arguments
////        if (args != null) {
////            charityId.text = args.getString("Charity Id")
////            charityname.text = args.getString("Charity Name")
////            charityaddress.text = args.getString("Charity Address")
////            charitycontact.text = args.getString("Charity Contact")
////            charityemail.text = args.getString("Charity Email")
////            charitydescription.text = args.getString("Charity Description")
////        }
//    }
//}

package com.example.madproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CardDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_card_details, container, false)
        val confirmCardBtn : Button = view.findViewById(R.id.btn_addCard)
        val backToCharityBtn : Button = view.findViewById(R.id.btn_cancleCard)

        confirmCardBtn.setOnClickListener {
            val fragment = ConfirmDonation()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment)?.commit()
        }

//        backToCharityBtn.setOnClickListener {
//            val fragment2 = selected_charity()
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.fl_nav,fragment2)?.commit()
//        }

        return view
    }


}
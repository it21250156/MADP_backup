package com.example.madproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class DonationHistory : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_donation_history, container, false)
        val hisBackBtn : Button = view.findViewById(R.id.btn_his_back)

        hisBackBtn.setOnClickListener {
            val fragment = Profile()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment)?.commit()
        }
        return view
    }

}
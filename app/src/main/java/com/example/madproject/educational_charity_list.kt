package com.example.madproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class educational_charity_list : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_educational_charity_list, container, false)
        val backBtn : Button = view.findViewById(R.id.btn_edu_back)
        val readMoreBtn : Button = view.findViewById(R.id.btn_edu_read1)

        backBtn.setOnClickListener {
            val fragment = Charities()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment)?.commit()
        }

        readMoreBtn.setOnClickListener {
            val fragment2 = select_charity()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment2)?.commit()
        }
        return view
    }



}
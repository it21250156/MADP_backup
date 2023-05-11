package com.example.madproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class select_charity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_charity, container, false)
        val donateBtn : Button = view.findViewById(R.id.btn_donate)
        val backToCharitiCate : Button = view.findViewById(R.id.btn_backto_chari_list)

        donateBtn.setOnClickListener {
            val fragment = CardDetails()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment)?.commit()
        }

        backToCharitiCate.setOnClickListener {
            val fragment = educational_charity_list()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment)?.commit()
        }

        return view

    }


}
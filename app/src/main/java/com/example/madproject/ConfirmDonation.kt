package com.example.madproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ConfirmDonation : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm_donation, container, false)
        val confirmToPay : Button = view.findViewById(R.id.btn_pay_confirm)
        val backToCard : Button = view.findViewById(R.id.btn_pay_cancel)

        confirmToPay.setOnClickListener {
            val fragment = DonationHistory()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment)?.commit()
        }

        backToCard.setOnClickListener {
            val fragment2 = CardDetails()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment2)?.commit()
        }
        return view
    }


}
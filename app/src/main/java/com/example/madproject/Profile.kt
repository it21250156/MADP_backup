package com.example.madproject


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth



class Profile : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val resetButton : Button = view.findViewById(R.id.btn_profile_resetpw)
        val historyButton : Button = view.findViewById(R.id.btn_profile_donationhistory)

        resetButton.setOnClickListener{
            val fragment = ResetPW()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment)?.commit()
        }

        historyButton.setOnClickListener {
            val fragment2 = DonationHistory()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fl_nav,fragment2)?.commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val profileLogoutBtn: Button = view.findViewById(R.id.btn_profile_logout)

        profileLogoutBtn.setOnClickListener {
        //logout from firebase
            auth.signOut()

            //back to login page
            val intent = Intent(activity, LoginActivity2::class.java)
            startActivity(intent)

            //to prevent user from going back
            activity?.finish()
        }
    }


}
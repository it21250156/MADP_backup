package com.example.madproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.example.madproject.databinding.ActivityCustomerMainBinding

class CustomerMain : AppCompatActivity() {

    private lateinit var binding : ActivityCustomerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Feed())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.feed -> replaceFragment(Feed())
                R.id.charities -> replaceFragment(Charities())
                R.id.notifi -> replaceFragment(Notifications())
                R.id.profile -> replaceFragment(Profile())

                else -> {

                }
            }
            true

        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_nav,fragment)
        fragmentTransaction.commit()
    }

}
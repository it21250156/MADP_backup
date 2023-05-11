package com.example.madproject


import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class Profile : Fragment() {

    private lateinit var tvName: TextView
    private lateinit var etEmail: EditText
    private lateinit var etMobileNum: EditText
    private lateinit var btnSaveChanges: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseFirestore

    // Get a reference to the current user's document in Firestore
    private var currentUser = FirebaseAuth.getInstance().currentUser
    private var userDocumentRef = FirebaseFirestore.getInstance().collection("users").document(currentUser!!.uid)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val resetButton : Button = view.findViewById(R.id.btn_profile_resetpw)
        val historyButton : Button = view.findViewById(R.id.btn_profile_donationhistory)



        // Initialize variables to hold data
        tvName = view.findViewById(R.id.tv_profile_name)
        etEmail = view.findViewById(R.id.edt_profile_email)
        etMobileNum = view.findViewById(R.id.edt_profile_mobile)
        btnSaveChanges = view.findViewById(R.id.btn_profile_editProfile)

        //Retrieve user data
        userDocumentRef.get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot != null) {
                    // Get the user data from the document snapshot
                    val name = documentSnapshot.getString("name")
                    val email = documentSnapshot.getString("email")
                    val mobileNo = documentSnapshot.getString("mobile_number")

                    //set user data in fields
                    tvName.text = name
                    etEmail.setText(email)
                    etMobileNum.setText(mobileNo)
                }
            }
            .addOnFailureListener{ e ->
                Log.e(TAG, "Error getting user document", e)
            }

        btnSaveChanges.setOnClickListener {
            performSaveChanges()
        }


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

    private fun performSaveChanges() {
        // get new data from user
        val newEmail = etEmail.text.toString().trim()
        val newMobileNo = etMobileNum.text.toString().trim()

        // map updated user data
        val newData = hashMapOf(
            "email" to newEmail,
            "mobile_number" to newMobileNo
        ) as MutableMap<String, Any>

        currentUser?.updateEmail(newEmail)
            ?.addOnSuccessListener {
                // update database with new data
                userDocumentRef.update(newData)
                    .addOnSuccessListener {
                        Toast.makeText(context, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener{ e ->
                        Log.e(TAG, "Error updating user data")
                        Toast.makeText(context, "Failed to update profile", Toast.LENGTH_SHORT).show()
                    }
            }
            ?.addOnFailureListener { e ->
                Log.e(TAG, "Error updating email in Firebase Authentication", e)
                Toast.makeText(context, "Failed to update email in Firebase Authentication", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()

        // get reference for current user data
        currentUser = auth.currentUser!!
        userDocumentRef = database.collection("users").document(currentUser!!.uid)

        val deleteUserBtn: Button = view.findViewById(R.id.btn_profile_deleteacc)
        deleteUserBtn.setOnClickListener {
            performDeleteUser()
        }

        val profileLogoutBtn: Button = view.findViewById(R.id.btn_profile_logout)

        profileLogoutBtn.setOnClickListener {
            // logout from firebase
            auth.signOut()

            // back to login page
            val intent = Intent(activity, LoginActivity2::class.java)
            startActivity(intent)

            // to prevent user from going back
            activity?.finish()
        }
    }

    private fun performDeleteUser() {
        // show a confirmation dialog to user
        AlertDialog.Builder(requireContext())
            .setTitle("Delete User Account")
            .setMessage("Are you sure you want to delete your account?")
            .setPositiveButton("Yes, I'm Sure"){_, _ ->
                // delete user from database and sign out the user
                userDocumentRef.delete()
                    .addOnSuccessListener {
                        Toast.makeText(context, "Account Deleted Successfully", Toast.LENGTH_SHORT).show()
                        auth.signOut()

                        val intent = Intent(requireContext(), LoginActivity2::class.java)
                        startActivity(intent)
                        requireActivity().finish()
                    }
                    .addOnFailureListener{ e ->
                        Log.e(TAG, "Error deleting user document", e)
                        Toast.makeText(context, "Failed to delete account", Toast.LENGTH_SHORT).show()
                    }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }


}
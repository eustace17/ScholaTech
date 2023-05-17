package com.example.appdevelopmenttrialtwo

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appdevelopmenttrialtwo.databinding.ActivityCallOutStudentBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CallOutStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCallOutStudentBinding
    private lateinit var database: DatabaseReference
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallOutStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase database reference
        database = Firebase.database.reference.child("outstandingFees")

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please Wait")

        binding.Viewcalledout.setOnClickListener {
            val itwa = Intent(this@CallOutStudentActivity, CallOutListViewActivity::class.java)
            startActivity(itwa)
        }

        binding.btncallout.setOnClickListener {
            val name = binding.calloutname.editText?.text.toString().trim()
            val upi = binding.calloutupi.editText?.text.toString().trim()

            if (name.isNotEmpty() && upi.isNotEmpty()) {
                // Check if the student has an outstanding balance
                database.child(upi).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            // The student has an outstanding balance
                            // Display a message to the user
                            Toast.makeText(
                                this@CallOutStudentActivity,
                                "The student has an outstanding balance.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            // Proceed with the call-out process
                            progressDialog.show()
                            val callout = CallOutClass(name, upi)

                            // Create a reference to the Firebase database
                            val calloutRef = database.child(upi)

                            calloutRef.setValue(callout).addOnCompleteListener {
                                progressDialog.dismiss()
                                if (it.isSuccessful) {
                                    // Call-out successful
                                    Toast.makeText(
                                        this@CallOutStudentActivity,
                                        "Student called out successfully!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    finish()
                                } else {
                                    // Call-out failed
                                    Toast.makeText(
                                        this@CallOutStudentActivity,
                                        "Failed to call out student. Please try again.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle database error
                        Toast.makeText(
                            this@CallOutStudentActivity,
                            "An error occurred. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
            } else {
                Toast.makeText(this, "Please enter name and UPI number.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

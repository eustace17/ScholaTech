package com.example.appdevelopmenttrialtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.appdevelopmenttrialtwo.databinding.ActivityMainBinding
import com.example.appdevelopmenttrialtwo.databinding.ActivityRegisterBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class RegisterStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase database reference
        database = Firebase.database.reference.child("outstandingFees")

        binding.mBtnRegister.setOnClickListener {
            val name = binding.mEdtStdName.text.toString().trim()
            val doa = binding.mEdtDOA.text.toString().trim()
            val dob = binding.mEdtDOB.text.toString().trim()
            val admno = binding.mEdtAdmNo.text.toString().trim()
            val grade = binding.mEdtGrade.text.toString().trim()
            val upi = binding.UPI.text.toString().trim()

            //Parent's Details
            val fname = binding.mEdtFrName.text.toString().trim()
            val fcell = binding.mEdtFrCell.text.toString().trim()
            val fid = binding.mEdtFrId.text.toString().trim()

            val mname = binding.mEdtMrName.text.toString().trim()
            val mcell = binding.mEdtMrCell.text.toString().trim()

            val mid = binding.mEdtMrId.text.toString().trim()

            val errorRequired = getString(R.string.error_required_field)

            if (name.isBlank()) {
                binding.mEdtStdName.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (doa.isBlank()) {
                binding.mEdtDOA.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (dob.isBlank()) {
                binding.mEdtDOB.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (admno.isBlank()) {
                binding.mEdtAdmNo.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (grade.isBlank()) {
                binding.mEdtGrade.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (upi.isBlank()) {
                binding.UPI.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (fname.isBlank()) {
                binding.mEdtFrName.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (fcell.isBlank()) {
                binding.mEdtFrCell.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (fid.isBlank()) {
                binding.mEdtFrId.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (mname.isBlank()) {
                binding.mEdtMrName.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (mcell.isBlank()) {
                binding.mEdtMrCell.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else if (mid.isBlank()) {
                binding.mEdtMrId.apply {
                    error = errorRequired
                    requestFocus()
                }
            } else {
                // Proceed with the registration process as usual
                if (name.isNotEmpty() && upi.isNotEmpty()) {
                    // Check if the student has an outstanding balance
                    database.child(upi).addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                // The student has an outstanding balance in a previous school
                                // Display a message to the user
                                AlertDialog.Builder(this@RegisterStudentActivity)
                                    .setTitle("Registration Error")
                                    .setMessage("The student cannot be registered because they have an outstanding balance in a previous school.")
                                    .setPositiveButton("OK", null)
                                    .show()
                            } else {
                                // Proceed with the registration process as usual


                                // Register the student by saving the data to the database

                                val student = Student(name, doa, dob, admno, grade, upi, fname, fcell, fid,  mname, mcell, mid,)
                                val parent = Parent(fname, fcell, fid,  mname, mcell, mid,)

                                // Save the student and parent data to the database
                                val studentRef = Firebase.database.reference.child("students").push()
                                studentRef.setValue(student)

                                val parentRef = Firebase.database.reference.child("parents").push()
                                parentRef.setValue(parent)

                                // Registration successful, display a toast message
                                Toast.makeText(this@RegisterStudentActivity, "Registration successful!", Toast.LENGTH_SHORT).show()
                            }
                        }
                        override fun onCancelled(error: DatabaseError) {
                            // Handle database error
                        }
                    })
                } else {
                    Toast.makeText(
                        this@RegisterStudentActivity,
                        "Please enter name and UPI number.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        binding.mBtnBack.setOnClickListener {
            val rudi = Intent(this@RegisterStudentActivity, MainActivity::class.java)
            startActivity(rudi)
        }
    }
}
package com.example.appdevelopmenttrialtwo

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appdevelopmenttrialtwo.databinding.ActivityTrRegistrationBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TrRegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrRegistrationBinding
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTrRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving")
        progressDialog.setMessage("Please wait...")

        binding.TrView.setOnClickListener {
            val onaTr = Intent(this@TrRegistrationActivity, TeacherActivity::class.java)
            startActivity(onaTr)
        }

        binding.saveTr.setOnClickListener {
            val name = binding.TrName.editText?.text.toString().trim()
            val phone = binding.TrPhone.editText?.text.toString().trim()
            val id = binding.TrIdNo.editText?.text.toString().trim()
            val tsc = binding.TscNo.editText?.text.toString().trim()

            // Check if user is submitting empty fields
            if (name.isEmpty()) {
                binding.TrName.setError("Please fill this input")
                binding.TrName.requestFocus()
            } else if (phone.isEmpty()) {
                binding.TrPhone.setError("Please fill out this field")
                binding.TrPhone.requestFocus()
            } else if (id.isEmpty()) {
                binding.TrIdNo.setError("Please fill out this input")
                binding.TrIdNo.requestFocus()
            } else if (tsc.isBlank()) {
                binding.TscNo.setError("Please fill this input")
                binding.TscNo.requestFocus()
            } else {
                // Proceed to save
                val teacher = Teacher(name, phone, id, tsc)

                // Create a reference to the Firebase database
                val teacherRef = Firebase.database.reference.child("teachers").push()
                progressDialog.show()
                teacherRef.setValue(teacher).addOnCompleteListener {
                    progressDialog.dismiss()
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Teacher saved successfully!", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Teacher Saving Failed!!!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

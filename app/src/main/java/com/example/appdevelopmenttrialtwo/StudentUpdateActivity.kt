package com.example.appdevelopmenttrialtwo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appdevelopmenttrialtwo.databinding.ActivityStudentUpdateBinding
import com.google.firebase.database.FirebaseDatabase

class StudentUpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentUpdateBinding
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase database reference
        database = FirebaseDatabase.getInstance()

        // Retrieve student details from intent
        val studentId = intent.getStringExtra("studentId")
        val studentRef = studentId?.let { database.reference.child("students").child(it) }

        studentRef?.get()?.addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val student = snapshot.getValue(Student::class.java)

                // Update UI with student details
                binding.mEdtStdName.setText(student?.name)
                binding.mEdtDOA.setText(student?.doa)
                binding.mEdtDOB.setText(student?.dob)
                binding.mEdtAdmNo.setText(student?.admno)
                binding.mEdtGrade.setText(student?.grade)
                binding.UPI.setText(student?.upi)
                binding.mEdFrName.setText(student?.fname)
                binding.mEdtFrCell.setText(student?.fcell)
                binding.mEdtFrId.setText(student?.fid)
                binding.mEdtMrName.setText(student?.mname)
                binding.mEdtMrCell.setText(student?.mcell)
                binding.mEdtMrId.setText(student?.mid)
            }
        }

        binding.mBtnUpdate.setOnClickListener {
            // Retrieve updated student details from UI
            val name = binding.mEdtStdName.text.toString().trim()
            val doa = binding.mEdtDOA.text.toString().trim()
            val dob = binding.mEdtDOB.text.toString().trim()
            val admno = binding.mEdtAdmNo.text.toString().trim()
            val grade = binding.mEdtGrade.text.toString().trim()
            val upi = binding.UPI.text.toString().trim()
            val fname = binding.mEdFrName.text.toString().trim()
            val fcell = binding.mEdtFrCell.text.toString().trim()
            val fid = binding.mEdtFrId.text.toString().trim()
            val fjob = binding.mEdtFrOccupation.text.toString().trim()
            val mname = binding.mEdtMrName.text.toString().trim()
            val mcell = binding.mEdtMrCell.text.toString().trim()
            val mjob = binding.mEdtMrJob.text.toString().trim()
            val mid = binding.mEdtMrId.text.toString().trim()

            // Update the student details in the database
            studentRef?.setValue(Student(name, doa, dob, admno, grade, upi, fname, fcell, fid, mname, mcell, mid,))

            // Display a toast message to indicate successful update
            Toast.makeText(this@StudentUpdateActivity, "Student details updated!", Toast.LENGTH_SHORT).show()
        }
    }
}

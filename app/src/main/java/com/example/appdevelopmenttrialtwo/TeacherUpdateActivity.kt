package com.example.appdevelopmenttrialtwo
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appdevelopmenttrialtwo.databinding.ActivityTeacherUpdateBinding
import com.google.firebase.database.FirebaseDatabase

class TeacherUpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeacherUpdateBinding
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving")
        progressDialog.setMessage("Please wait...")

        val receivedName = intent.getStringExtra("name")
        val receivedPhone = intent.getStringExtra("phone")
        val receivedId = intent.getStringExtra("id")
        val receivedTsc = intent.getStringExtra("tsc")

        // Set the received data to EditTexts
        binding.TrName.editText?.setText(receivedName)
        binding.TrPhone.editText?.setText(receivedPhone)
        binding.TrIdNo.editText?.setText(receivedId)
        binding.TscNo.editText?.setText(receivedTsc)

        binding.mBtnUpdate.setOnClickListener {
            val name = binding.TrName.editText?.text.toString().trim()
            val phone = binding.TrPhone.editText?.text.toString().trim()
            val id = binding.TrIdNo.editText?.text.toString().trim()
            val tsc = binding.TscNo.editText?.text.toString().trim()

            if (name.isEmpty()) {
                binding.TrName.setError("Please fill in the fields")
                binding.TrName.requestFocus()
            } else if (phone.isEmpty()) {
                binding.TrPhone.setError("Please fill in the fields")
                binding.TrPhone.requestFocus()
            } else if (id.isEmpty()) {
                binding.TrIdNo.setError("Please fill in the fields")
                binding.TrIdNo.requestFocus()
            } else if (tsc.isEmpty()) {
                binding.TscNo.setError("Please fill in the fields")
                binding.TscNo.requestFocus()
            } else {
                // Proceed to save
                val teacher = Teacher(name, phone, id, tsc)

                // Create a reference in the Firebase database
                val ref = FirebaseDatabase.getInstance().getReference().child("teachers/").child(tsc)

                // Show the progress dialog to start saving
                progressDialog.show()
                ref.setValue(teacher).addOnCompleteListener { task ->
                    progressDialog.dismiss()
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Teacher updated successfully", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@TeacherUpdateActivity, TeacherActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Teacher updating failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
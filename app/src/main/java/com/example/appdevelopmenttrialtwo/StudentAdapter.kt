package com.example.appdevelopmenttrialtwo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class StudentAdapter(private val context: Context, private val data: ArrayList<Student>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        val nameTextView: TextView = row?.findViewById(R.id.mEdtStdName) as TextView
        val dobTextView: TextView = row?.findViewById(R.id.mEdtDOB) as TextView
        val doaTextView: TextView = row?.findViewById(R.id.mEdtDOA) as TextView
        val admnoTextView: TextView = row?.findViewById(R.id.mEdtAdmNo) as TextView
        val gradeTextView: TextView = row?.findViewById(R.id.mEdtGrade) as TextView
        val upiTextView: TextView = row?.findViewById(R.id.UPI) as TextView
        val frnameTextView: TextView = row?.findViewById(R.id.mEdFrName) as TextView
        val frcellTextView: TextView = row?.findViewById(R.id.mEdtFrCell) as TextView
        val fridTextView: TextView = row?.findViewById(R.id.mEdtFrId) as TextView
        val frjobTextView: TextView = row?.findViewById(R.id.mEdtFrOccupation) as TextView
        val mrnameTextView: TextView = row?.findViewById(R.id.mEdtMrName) as TextView
        val mrcellTextView: TextView = row?.findViewById(R.id.mEdtMrCell) as TextView
        val mrjobTextView: TextView = row?.findViewById(R.id.mEdtMrJob) as TextView
        val mridTextView: TextView = row?.findViewById(R.id.mEdtMrId) as TextView
        val deleteButton: Button = row?.findViewById(R.id.mBtnDelete) as Button
        val updateButton: Button = row?.findViewById(R.id.mBtnUpdate) as Button
    }

    override fun getView(position: Int, convertView: View?, student: ViewGroup?): View {
        var view = convertView
        var viewHolder: ViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.student_layout, student, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val student = getItem(position) as Student
        viewHolder.nameTextView.text = student.name
        viewHolder.doaTextView.text = student.doa
        viewHolder.dobTextView.text = student.dob
        viewHolder.admnoTextView.text = student.admno
        viewHolder.gradeTextView.text = student.grade
        viewHolder.upiTextView.text = student.upi
        viewHolder.frnameTextView.text = student.fname
        viewHolder.fridTextView.text = student.fid
        viewHolder.mrnameTextView.text = student.mname
        viewHolder.mrcellTextView.text = student.mcell
        viewHolder.mridTextView.text = student.mid


        viewHolder.deleteButton.setOnClickListener {
            val ref = FirebaseDatabase.getInstance().getReference("students").child(student.upi)
            ref.removeValue().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Student Details deleted successfully", Toast.LENGTH_LONG).show()
                    data.removeAt(position) // Remove teacher from the data list
                    notifyDataSetChanged() // Refresh the adapter's view
                } else {
                    Toast.makeText(context, "Deleting Student Details failed", Toast.LENGTH_LONG).show()
                }
            }
        }

        viewHolder.updateButton.setOnClickListener {
            // Handle update button click here
            // Add your logic to update teacher information
                var intent = Intent(context,StudentUpdateActivity::class.java)
                intent.putExtra("name",student.name)
                intent.putExtra("doa",student.doa)
                intent.putExtra("dob",student.dob)
                intent.putExtra("admno",student.admno)
                intent.putExtra("grade",student.grade)
                intent.putExtra("upi",student.upi)
                intent.putExtra("Father's Name",student.fname)
                intent.putExtra("Father's Id",student.fid)
                intent.putExtra("Mother's Name",student.mname)
                intent.putExtra("Mother's Cell",student.mcell)
                intent.putExtra("Mother's Id",student.mid)
            context.startActivity(intent)
        }

        return view as View
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}


//viewHolder.updateButton.setOnClickListener {
//    val teacher = getItem(position) as Teacher
//
//    // Create a dialog or start a new activity to handle the update
//    // Here's an example using a dialog
//    val dialog = AlertDialog.Builder(context)
//    val inflater = LayoutInflater.from(context)
//    val dialogView = inflater.inflate(R.layout.update_dialog, null)
//    dialog.setView(dialogView)
//
//    val nameEditText = dialogView.findViewById<EditText>(R.id.editTextName)
//    val phoneEditText = dialogView.findViewById<EditText>(R.id.editTextPhone)
//    val tscEditText = dialogView.findViewById<EditText>(R.id.editTextTsc)
//
//    // Set the current values of the teacher in the dialog
//    nameEditText.setText(teacher.name)
//    phoneEditText.setText(teacher.phone)
//    tscEditText.setText(teacher.tsc)
//
//    dialog.setPositiveButton("Save") { dialogInterface, _ ->
//        val updatedName = nameEditText.text.toString().trim()
//        val updatedPhone = phoneEditText.text.toString().trim()
//        val updatedTsc = tscEditText.text.toString().trim()
//
//        if (updatedName.isNotEmpty() && updatedPhone.isNotEmpty() && updatedTsc.isNotEmpty()) {
//            // Update the teacher's information in the database
//            val ref = FirebaseDatabase.getInstance().getReference("teachers").child(teacher.id)
//            val updatedTeacher = Teacher(teacher.id, updatedName, updatedPhone, updatedTsc)
//            ref.setValue(updatedTeacher).addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    Toast.makeText(context, "Teacher updated successfully", Toast.LENGTH_LONG).show()
//                    // Update the teacher's information in the data list
//                    teacher.name = updatedName
//                    teacher.phone = updatedPhone
//                    teacher.tsc = updatedTsc
//                    notifyDataSetChanged() // Refresh the adapter's view
//                } else {
//                    Toast.makeText(context, "Updating teacher failed", Toast.LENGTH_LONG).show()
//                }
//            }
//        } else {
//            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
//        }
//
//        dialogInterface.dismiss()
//    }
//
//    dialog.setNegativeButton("Cancel") { dialogInterface, _ ->
//        dialogInterface.dismiss()
//    }
//
//    dialog.show()
//}
package com.example.appdevelopmenttrialtwo

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.FirebaseDatabase



class TeacherAdapter(private val context: Context, private val data: ArrayList<Teacher>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        val nameTextView: TextView = row?.findViewById(R.id.TrName) as TextView
        val phoneTextView: TextView = row?.findViewById(R.id.TrPhone) as TextView
        val idTextView: TextView = row?.findViewById(R.id.TrIdNo) as TextView
        val tscTextView: TextView = row?.findViewById(R.id.TscNo) as TextView
        val deleteButton: Button = row?.findViewById(R.id.mBtnDelete) as Button
        val updateButton: Button = row?.findViewById(R.id.mBtnUpdate) as Button
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var viewHolder: ViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.teacher_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val teacher = getItem(position) as Teacher
        viewHolder.nameTextView.text = teacher.name
        viewHolder.phoneTextView.text = teacher.phone
        viewHolder.idTextView.text = teacher.Id
        viewHolder.tscTextView.text = teacher.tsc

        viewHolder.deleteButton.setOnClickListener {
            val ref = FirebaseDatabase.getInstance().getReference("teachers").child(teacher.Id)
            ref.removeValue().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Teacher deleted successfully", Toast.LENGTH_LONG)
                        .show()
                    data.removeAt(position) // Remove teacher from the data list
                    notifyDataSetChanged() // Refresh the adapter's view
                } else {
                    Toast.makeText(context, "Deleting teacher failed", Toast.LENGTH_LONG).show()
                }
            }
        }

        viewHolder.updateButton.setOnClickListener {
            var intent = Intent(context, TeacherUpdateActivity::class.java)
            intent.putExtra("name", teacher.name)
            intent.putExtra("phone", teacher.phone)
            intent.putExtra("idNumber", teacher.Id)
            intent.putExtra("TSC Number", teacher.tsc)
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





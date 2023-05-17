package com.example.appdevelopmenttrialtwo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class CallOutAdapter(private val context: Context, private val data: ArrayList<CallOutClass>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        val nameTextView: TextView = row?.findViewById(R.id.calloutname) as TextView
        val upiTextView: TextView = row?.findViewById(R.id.calloutupi) as TextView
        val deleteButton: Button = row?.findViewById(R.id.mBtnDelete) as Button
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var viewHolder: ViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.callout_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val call = getItem(position) as CallOutClass
        viewHolder.nameTextView.text = call.name
        viewHolder.upiTextView.text = call.upi


        viewHolder.deleteButton.setOnClickListener {
            val ref = FirebaseDatabase.getInstance().getReference().child("outstandingFees").child(call.upi)
            ref.removeValue().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Callerd Out Student  deleted successfully", Toast.LENGTH_LONG)
                        .show()
                    data.removeAt(position) // Remove teacher from the data list
                    notifyDataSetChanged() // Refresh the adapter's view
                } else {
                    Toast.makeText(context, "Deleting Called Out Student failed", Toast.LENGTH_LONG).show()
                }
            }
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

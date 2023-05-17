package com.example.appdevelopmenttrialtwo

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CallOutListViewActivity : AppCompatActivity() {
    lateinit var listUsers : ListView
    lateinit var users : ArrayList<CallOutClass>
    lateinit var adapter: CallOutAdapter
    lateinit var progressDialog : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_callout_list_view)
        listUsers = findViewById(R.id.mListcalledoutStudents)
        users = ArrayList()
        adapter = CallOutAdapter(this,users)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please Wait")


        //Create a reference to the database to load data
        var ref = FirebaseDatabase.getInstance().getReference().child("outstandingFees")

        //Show Progress as you load data
        progressDialog.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                users.clear()
                for (data in snapshot.children){
                    var user = data.getValue(CallOutClass::class.java)
                    users.add(user!!)
                }
                adapter.notifyDataSetChanged()
                progressDialog.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@CallOutListViewActivity,
                    "DB is inaccessible...Lipa boss", Toast.LENGTH_LONG).show()                                                          //To deny access to DB if client hasn't paid....also change the rules in firebase to false

            }
        })
        listUsers.adapter = adapter
    }
}
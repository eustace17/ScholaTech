package com.example.appdevelopmenttrialtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    lateinit var btnregstd : Button
    lateinit var btnregtr : Button
    lateinit var btncallout:Button
    lateinit var btnstdview:Button
    lateinit var btntrview:Button
    lateinit var logout:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnregstd = findViewById(R.id.mBtnRegStd)
        btnregtr = findViewById(R.id.mBtnRegTr)
        btncallout = findViewById(R.id.mBtnCallOut)
        btnstdview = findViewById(R.id.mBtnViewStd)
        btntrview = findViewById(R.id.mBtnViewTr)
        logout = findViewById(R.id.LogOut)


        btnregstd.setOnClickListener {
            val sajilistd = Intent(this@MainActivity, RegisterStudentActivity::class.java)
            startActivity(sajilistd)
        }
        btnregtr.setOnClickListener {
            val sajilitr = Intent(this@MainActivity, TrRegistrationActivity::class.java)
            startActivity(sajilitr)
        }
        btncallout.setOnClickListener {
            val ita = Intent(this@MainActivity, CallOutStudentActivity::class.java)
            startActivity(ita)
        }
        btnstdview.setOnClickListener {
            val onafunzi = Intent(this@MainActivity, StudentActivity::class.java)
            startActivity(onafunzi)
        }
        btntrview.setOnClickListener {
            val onatr = Intent(this@MainActivity, TeacherActivity::class.java)
            startActivity(onatr)

        }
        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            // Redirect the user to the login or home screen
            val logout = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(logout)
        }


    }
}
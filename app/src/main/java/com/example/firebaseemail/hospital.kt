package com.example.firebaseemail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hospital.*

class hospital : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)

        UttarPradesh.setOnClickListener {
            val i= Intent(this,UpHospital::class.java)
            startActivity(i)
        }
        Bengaluru.setOnClickListener {
            val i= Intent(this,hospital_resource::class.java)
            startActivity(i)
        }

    }
}
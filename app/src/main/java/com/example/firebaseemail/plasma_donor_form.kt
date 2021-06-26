package com.example.firebaseemail

import android.nfc.Tag
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import android.os.Binder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.firebaseemail.databinding.ActivityLoginBinding
import com.example.firebaseemail.databinding.ActivityPlasmaDonorFormBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_plasma_donor_form.*


class plasma_donor_form : AppCompatActivity() {

    private lateinit var binding : ActivityPlasmaDonorFormBinding
    private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPlasmaDonorFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener{
            val Name = binding.Name.text.toString()
            val phone = binding.phone.text.toString()
            val zipcode = binding.zipcode.text.toString()
            val bgroup = binding.bgroup.text.toString()


            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(Name,phone,zipcode,bgroup)
            Log.d("hi", User.toString())
            database.child(Name).setValue(User).addOnSuccessListener {

                binding.Name.text.clear()
                binding.phone.text.clear()
                binding.zipcode.text.clear()
                binding.bgroup.text.clear()

                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()


            }
        }
    }
}
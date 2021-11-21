package com.example.firebaseemail

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseemail.Dataclass.User
import com.example.firebaseemail.Dataclass.userRegister
import com.example.firebaseemail.databinding.ActivityPlasmaDonorFormBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class plasma_donor_form : AppCompatActivity() {

    private lateinit var binding : ActivityPlasmaDonorFormBinding
    private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPlasmaDonorFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener{
            val Address = binding.zipcode.text.toString()
            val bgroup = binding.bgroup.text.toString()


            val cuser = FirebaseAuth.getInstance().currentUser
            val uid = cuser?.uid
            database = FirebaseDatabase.getInstance().getReference("Users").child("$uid")
            val User = User(Address,bgroup)
            //Log.d("hi", User.toString())
            database.child("Donor Detail").setValue(User).addOnSuccessListener {



                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()


            }
        }
    }
}
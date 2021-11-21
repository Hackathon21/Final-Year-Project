package com.example.firebaseemail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.firebaseemail.Dataclass.User
import com.example.firebaseemail.Dataclass.userRegister

import com.example.firebaseemail.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        switch_to_login.setOnClickListener{
            startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
        }



        register.setOnClickListener{
            when {
                TextUtils.isEmpty(formEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter email..",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(formName.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this@RegisterActivity, "Please enter name..", Toast.LENGTH_SHORT)
                        .show()
                }

                TextUtils.isEmpty(phone.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this@RegisterActivity, "Please enter Phone Number..", Toast.LENGTH_SHORT)
                        .show()
                }

                TextUtils.isEmpty(formPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter Password..",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(formConfirmPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter Password..",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val name = binding.formName.text.toString()
                    val phone = binding.phone.text.toString()
                    val password = binding.formPassword.text.toString()
                    val email = binding.formEmail.text.toString()


                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            {task ->
                                if(task.isSuccessful){
                                    val firebaseUser: FirebaseUser =task.result!!.user!!
                                    database = FirebaseDatabase.getInstance().getReference("Users")
                                    //val user = FirebaseAuth.getInstance().currentUser
                                    val uid=firebaseUser.uid
                                    val userRegister = userRegister(uid,name,phone,email,password)

                                    database.child(uid).setValue(userRegister).addOnSuccessListener {
                                        Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()
                                    }.addOnFailureListener{
                                        Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
                                    }
                                    Toast.makeText(this@RegisterActivity,"Your are registered Successfully",
                                    Toast.LENGTH_SHORT).show()

                                    val intent =
                                        Intent(this@RegisterActivity,LoginActivity::class.java)
                                    intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    startActivity(intent)
                                    finish()
                                }
                                else {
                                    Toast.makeText(
                                        this@RegisterActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                }
            }
        }


    }
}
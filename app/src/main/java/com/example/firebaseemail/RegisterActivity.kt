package com.example.firebaseemail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

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
                    val email: String = formEmail.text.toString().trim { it <= ' ' }
                    val name: String = formName.text.toString().trim { it <= ' ' }
                    val password: String = formPassword.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            {task ->
                                if(task.isSuccessful){
                                    val firebaseUser: FirebaseUser=task.result!!.user!!
                                    Toast.makeText(this@RegisterActivity,"Your are registered Successfully",
                                    Toast.LENGTH_SHORT).show()

                                    val intent =
                                        Intent(this@RegisterActivity,LoginActivity::class.java)
                                    intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    //intent.putExtra("user_id",firebaseUser.uid)
                                    //intent.putExtra("email_id",email)
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

        switch_to_login.setOnClickListener{
        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
        }
    }
}
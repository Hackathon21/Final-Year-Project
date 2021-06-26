package com.example.firebaseemail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        switch_to_register.setOnClickListener{
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }

        login.setOnClickListener{
            when {
                TextUtils.isEmpty(Email.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter email..",
                        Toast.LENGTH_SHORT
                    ).show()
                }


                TextUtils.isEmpty(Password.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter Password..",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = Email.text.toString().trim { it <= ' ' }
                    val password: String = Password.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            {task ->
                                if(task.isSuccessful){
                                    val firebaseUser: FirebaseUser =task.result!!.user!!
                                    Toast.makeText(this@LoginActivity,"Your are Logged in Successfully",
                                        Toast.LENGTH_SHORT).show()

                                  val intent =
                                       Intent(this@LoginActivity,MainActivity::class.java)
//                                    intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                                    //intent.putExtra("user_id",firebaseUser.uid)
//                                    //intent.putExtra("email_id",email)
                                    startActivity(intent)
                                    finish()
                                }
                                else {
                                    Toast.makeText(
                                        this@LoginActivity,
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
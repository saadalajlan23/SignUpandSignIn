package com.example.signupandsignin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    private lateinit var mobileEd: EditText
    private lateinit var passwordEd: EditText
    private lateinit var db: DatabaseHelper
    private lateinit var signInBtn: Button
    private lateinit var backBtn: Button
    private lateinit var pw: String
    private lateinit var spf: SharedPreferences
    private lateinit var editr: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        mobileEd = findViewById(R.id.editTextMobile)
        passwordEd = findViewById(R.id.editTextPassword)
        signInBtn = findViewById(R.id.signIn)
        backBtn = findViewById(R.id.back)
        db = DatabaseHelper(applicationContext)
        spf = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        editr = spf.edit()
        title = "Sign In"


        signInBtn.setOnClickListener {
            var mobile = mobileEd.text.toString()
            var password = passwordEd.text.toString()
            pw = db.checkpassword(mobile)
            if (pw.equals(password)) {
                editr.putString("mob", mobile).commit()

                Toast.makeText(applicationContext, "Sign in success!", Toast.LENGTH_SHORT).show();


                Intent(this, HomePage::class.java).apply {
                    startActivity(this)
                }

            } else {
                Toast.makeText(applicationContext, "Invaild details", Toast.LENGTH_SHORT).show();
            }
        }
        backBtn.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }

        }
    }
}
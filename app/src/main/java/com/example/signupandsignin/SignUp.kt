package com.example.signupandsignin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    private lateinit var nameEd: EditText
    private lateinit var locationEd: EditText
    private lateinit var mobileEd: EditText
    private lateinit var passwordEd: EditText
    private lateinit var db: DatabaseHelper
    private lateinit var signUpBtn: Button
    private lateinit var spf: SharedPreferences
    private lateinit var editr: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        nameEd = findViewById(R.id.editTextTextPersonName)
        locationEd = findViewById(R.id.editTextTextPersonName2)
        mobileEd = findViewById(R.id.editTextTextPersonName3)
        passwordEd = findViewById(R.id.editTextTextPersonName4)
        signUpBtn = findViewById(R.id.button3)
        db = DatabaseHelper(applicationContext)
        spf = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        editr = spf.edit()
        title = "Sign Up"

        signUpBtn.setOnClickListener {
            var name = nameEd.text.toString()
            var location = locationEd.text.toString()
            var mobile = mobileEd.text.toString()
            var password = passwordEd.text.toString()

            var save = db.savedet(name, location, mobile, password)

            Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
                .show();
            if (save.equals("-1")) {
                Toast.makeText(applicationContext, "Error data not saved!", Toast.LENGTH_SHORT)
                    .show();
            } else {
                editr.putString("mob", mobile).commit()
                Toast.makeText(applicationContext, "save success!", Toast.LENGTH_SHORT).show();
                Intent(this, HomePage::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }
}
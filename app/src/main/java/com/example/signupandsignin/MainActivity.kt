package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Main"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotosignin(view: android.view.View) {
        Intent(this, SignIn::class.java).apply {
            startActivity(this)
        }
    }

    fun gotosignup(view: android.view.View) {
        Intent(this, SignUp::class.java).apply {
            startActivity(this)
        }
    }
}
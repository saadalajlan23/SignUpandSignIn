package com.example.signupandsignin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomePage : AppCompatActivity() {
    private lateinit var db: DatabaseHelper
    private lateinit var details: TextView
    private lateinit var details2: TextView
    private lateinit var signout: Button
    private lateinit var spf: SharedPreferences
    private lateinit var detailsUser: String
    private lateinit var detailsUser2: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        db = DatabaseHelper(applicationContext)
        details = findViewById(R.id.detail)
        details2 = findViewById(R.id.detail2)
        signout = findViewById(R.id.signout)
        spf = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        detailsUser2 = spf.getString("mob", "default value").toString()

        details.setText("Welcome " + detailsUser2 + "!" + "\n")
        title = "Details"

        detailsUser = db.getdet(detailsUser2)

        details2.setText("Your details are \n" + detailsUser + "\n")
        signout.setOnClickListener {
            Intent(this, SignIn::class.java).apply {
                startActivity(this)
            }


        }
    }
}
package com.example.catastrophiccafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ME_O_Mackerel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me_omackerel)

        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")

        val homeBtn = findViewById<Button>(R.id.homebtn)

        homeBtn.setOnClickListener() {
            val intent = Intent(this, LandingPage::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val about_us = findViewById<Button>(R.id.aboutUsbtn)

        about_us.setOnClickListener() {
            val intent = Intent(this, LandingPage::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val profile = findViewById<Button>(R.id.profileBtn)

        profile.setOnClickListener() {
            val intent = Intent(this, LandingPage::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}
package com.example.catastrophiccafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class profilePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        val home = findViewById<Button>(R.id.homebtn)

        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")

        val usernameText = findViewById<TextView>(R.id.username)
        val emailText = findViewById<TextView>(R.id.email)

        usernameText.text = username
        emailText.text = email


        home.setOnClickListener() {
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

        val logout = findViewById<Button>(R.id.logoutbtn)

        logout.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
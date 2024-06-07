package com.example.catastrophiccafe

import LoginInterface
import LoginRequest1
import LoginResponse
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private val baseURL = "https://catastrophiccafe.com/api/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn: Button = findViewById(R.id.loginBtn)

        loginBtn.setOnClickListener {
            login()
        }

        val signUpBtn: TextView = findViewById(R.id.signUp)

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    fun login() {

        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Toast.makeText(applicationContext, "Logging In", Toast.LENGTH_SHORT).show()
        val service = retrofit.create(LoginInterface::class.java)
        val request = LoginRequest1(
            email.text.toString(),
            password.text.toString(),
        )

        Log.d("Sign up", request.toString())
        Log.d("URL", baseURL)

        service.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        val intent = Intent(applicationContext, LandingPage::class.java)
                        Log.d("Login", loginResponse.toString())
                        Log.d("Login", loginResponse.user.name.toString())
                        intent.putExtra("username", loginResponse.user.name.toString())
                        intent.putExtra("email", loginResponse.user.email.toString())
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Invalid Email/Password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(applicationContext, "Log In Failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "Network error. Please try again.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}
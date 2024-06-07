package com.example.catastrophiccafe

import RegisterRequest
import RegisterResponse
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignUp : AppCompatActivity() {
    private lateinit var registerBtn : Button
    private lateinit var username : EditText
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var password_confirmation : EditText

private val baseURL = "https://catastrophiccafe.com/api/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        registerBtn = findViewById(R.id.registerBtn)
        username = findViewById(R.id.username)
        email = findViewById(R.id.email_register)
        password = findViewById(R.id.password)
        password_confirmation = findViewById(R.id.password_confirmation)

        registerBtn.setOnClickListener {
            register()
        }
    }

    private fun register() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Toast.makeText(applicationContext, "Registering", Toast.LENGTH_SHORT).show()
        val service = retrofit.create(RegisterInterface::class.java)
        val request = RegisterRequest(
            username.text.toString(),
            email.text.toString(),
            password.text.toString(),
            password_confirmation.text.toString()
        )

        Log.d("Sign Up", request.toString())
        Log.d("URL", baseURL)

        service.register(request).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse (call : Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null) {
                        Toast.makeText(applicationContext, "Account Created Successfully", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, LandingPage::class.java)
                        intent.putExtra ("username", username.text.toString())
                        intent.putExtra ("email", email.text.toString())
                        startActivity(intent)
                    } else {
                        Toast.makeText(applicationContext, "Null Response", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.d("Response", response.body().toString())
                    Toast.makeText(applicationContext, "Account Creation Failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure (call : Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Network Error. Please try again.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
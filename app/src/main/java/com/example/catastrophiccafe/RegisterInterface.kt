package com.example.catastrophiccafe

import RegisterRequest
import RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterInterface {
     @POST("register")
     fun register(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
}
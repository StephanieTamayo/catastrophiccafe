

import LoginRequest1
import LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("login")
    fun login(@Body loginRequest : LoginRequest1): Call<LoginResponse>
}
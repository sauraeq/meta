package com.API

import com.metaled.AuthenticationModel.ForgetPassModels.ChangePassResponse
import com.metaled.AuthenticationModel.LoginModel.ForgotResponse1
import com.metaled.AuthenticationModel.LoginModel.LoginResponse
import com.metaled.AuthenticationModel.SignUpModel.SignUpResponse
import com.metaled.AuthenticationModel.VeriFyotpModels.VerifyOtpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIConfiguration {
    @POST("customers/userSignup")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    fun SignUp(
        @Body stringStringHashMap: HashMap<String, String>,
    ): Call<SignUpResponse>

    @POST("customers/userlogin")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    fun LogIn(
        @Body stringStringHashMap: HashMap<String, String>,
    ): Call<LoginResponse>

    @POST("customers/forgotPassword")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    fun forgotpassword(
        @Body stringStringHashMap: HashMap<String, String>,
    ): Call<ForgotResponse1>

    @POST("customers/verifyEmail")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    fun verifyotp(
        @Body stringStringHashMap: HashMap<String, String>,
    ): Call<VerifyOtpResponse>

    @POST("customers/changePassword")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    fun changepassword(
        @Body stringStringHashMap: HashMap<String, String>,
    ): Call<ChangePassResponse>


}
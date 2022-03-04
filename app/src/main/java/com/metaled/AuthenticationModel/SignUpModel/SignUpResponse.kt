package com.metaled.AuthenticationModel.SignUpModel

data class SignUpResponse(
    val error: Int,
    val msg: String,
    val service: String,
    val success: String
)
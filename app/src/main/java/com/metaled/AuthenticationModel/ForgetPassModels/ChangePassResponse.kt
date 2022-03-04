package com.metaled.AuthenticationModel.ForgetPassModels

data class ChangePassResponse(
    val error: Int,
    val msg: String,
    val service: String,
    val star_count: String,
    val success: String
)
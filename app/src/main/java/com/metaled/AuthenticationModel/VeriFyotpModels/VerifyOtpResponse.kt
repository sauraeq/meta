package com.metaled.AuthenticationModel.VeriFyotpModels

data class VerifyOtpResponse(
    val `data`: Data,
    val error: Int,
    val msg: String,
    val service: String,
    val success: String
)
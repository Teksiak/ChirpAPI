package com.teksiak.chirp.user.api.request

data class LoginRequest(
    val email: String,
    val password: String,
)

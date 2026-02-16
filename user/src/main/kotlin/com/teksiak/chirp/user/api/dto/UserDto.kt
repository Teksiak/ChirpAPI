package com.teksiak.chirp.user.api.dto

import com.teksiak.chirp.user.domain.model.UserId

data class UserDto(
    val id: UserId,
    val username: String,
    val email: String,
    val hasVerifiedEmail: Boolean,
)

package com.teksiak.chirp.user.api.mappers

import com.teksiak.chirp.user.api.dto.AuthenticatedUserDto
import com.teksiak.chirp.user.api.dto.UserDto
import com.teksiak.chirp.user.domain.model.AuthenticatedUser
import com.teksiak.chirp.user.domain.model.User

fun User.toUserDto() = UserDto(
    id = id,
    username = username,
    email = email,
    hasVerifiedEmail = hasVerifiedEmail,
)

fun AuthenticatedUser.toAuthenticatedUserDto() = AuthenticatedUserDto(
    user = user.toUserDto(),
    accessToken = accessToken,
    refreshToken = refreshToken,
)
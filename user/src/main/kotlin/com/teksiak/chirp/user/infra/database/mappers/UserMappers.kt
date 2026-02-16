package com.teksiak.chirp.user.infra.database.mappers

import com.teksiak.chirp.user.domain.model.User
import com.teksiak.chirp.user.infra.database.entities.UserEntity

fun UserEntity.toUser() = User(
    id = id!!,
    email = email,
    username = username,
    hasVerifiedEmail = hasVerifiedEmail,
)
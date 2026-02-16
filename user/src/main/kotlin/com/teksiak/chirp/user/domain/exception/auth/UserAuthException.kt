package com.teksiak.chirp.user.domain.exception.auth

abstract class UserAuthException(override val message: String) : RuntimeException(message)

class UserAlreadyExistsException : UserAuthException(
    "A user with this username or email already exists."
)
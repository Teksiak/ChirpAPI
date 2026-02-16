package com.teksiak.chirp.user.service.auth

import com.teksiak.chirp.user.domain.exception.auth.UserAlreadyExistsException
import com.teksiak.chirp.user.domain.model.User
import com.teksiak.chirp.user.infra.database.entities.UserEntity
import com.teksiak.chirp.user.infra.database.mappers.toUser
import com.teksiak.chirp.user.infra.database.repositories.UserRepository
import com.teksiak.chirp.user.infra.security.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserAuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    fun registerUser(email: String, username: String, password: String): User {
        if (userRepository.existsByEmailOrUsername(email, username)) {
            throw UserAlreadyExistsException()
        }

        val encodedPassword = passwordEncoder.encode(password)
        val userEntity = UserEntity(
            email = email,
            username = username,
            hashedPassword = encodedPassword,
        )
        val savedUser = userRepository.save(userEntity)
        return savedUser.toUser()
    }
}
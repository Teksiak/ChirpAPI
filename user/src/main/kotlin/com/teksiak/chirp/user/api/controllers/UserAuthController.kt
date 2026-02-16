package com.teksiak.chirp.user.api.controllers

import com.teksiak.chirp.user.api.dto.UserDto
import com.teksiak.chirp.user.api.mappers.toUserDto
import com.teksiak.chirp.user.api.request.RegisterRequest
import com.teksiak.chirp.user.service.auth.UserAuthService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class UserAuthController(
    private val userAuthService: UserAuthService
) {

    @PostMapping("/registerUser")
    fun registerUser(
        @Valid @RequestBody body: RegisterRequest
    ): UserDto {
        return userAuthService.registerUser(
            email = body.email,
            username = body.username,
            password = body.password
        ).toUserDto()
    }
}
package com.teksiak.chirp.user.api.exceptionHandlers

import com.teksiak.chirp.user.domain.exception.auth.UserAlreadyExistsException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class UserAuthExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException::class)
    fun onUserAlreadyExistsException(
        e: UserAlreadyExistsException
    ): ResponseEntity<Map<String, Any>> {
        val response = mapOf(
            "code" to "USER_ALREADY_EXISTS",
            "message" to e.message
        )
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun onValidationException(
        e: MethodArgumentNotValidException
    ): ResponseEntity<Map<String, Any>> {
        val errors = e.bindingResult.fieldErrors.associate { it.field to (it.defaultMessage ?: "Invalid value") }
        val response = mapOf(
            "code" to "VALIDATION_ERROR",
            "message" to "Validation failed for one or more fields.",
            "errors" to errors
        )
        return ResponseEntity.badRequest().body(response)
    }
}
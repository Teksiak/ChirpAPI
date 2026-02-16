package com.teksiak.chirp.user.infra.database.repositories

import com.teksiak.chirp.user.domain.model.UserId
import com.teksiak.chirp.user.infra.database.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, UserId> {
    fun existsByEmailOrUsername(email: String, username: String): Boolean
    fun findByEmail(email: String): UserEntity?
    fun findByEmailOrUsername(email: String, username: String): UserEntity?
}
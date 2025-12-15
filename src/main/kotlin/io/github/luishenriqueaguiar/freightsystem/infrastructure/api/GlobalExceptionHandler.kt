package io.github.luishenriqueaguiar.freightsystem.infrastructure.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(ex: IllegalArgumentException): ResponseEntity<Map<String, String>> {
        val errorResponse = mapOf(
            "error" to "Bad Request",
            "message" to (ex.message ?: "Invalid parameter")
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    @ExceptionHandler(IllegalStateException::class)
    fun handleConflict(ex: IllegalStateException): ResponseEntity<Map<String, String>> {
        val errorResponse = mapOf(
            "error" to "Conflict",
            "message" to (ex.message ?: "Invalid state")
        )
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse)
    }
}
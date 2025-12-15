package io.github.luishenriqueaguiar.freightsystem.infrastructure.api

import io.github.luishenriqueaguiar.freightsystem.application.dto.CreateFreightInput
import io.github.luishenriqueaguiar.freightsystem.application.dto.FreightOutput
import io.github.luishenriqueaguiar.freightsystem.application.usecase.CreateFreightUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/freights")
class FreightController(
    private val createFreightUseCase: CreateFreightUseCase
) {

    @PostMapping
    fun create(@RequestBody input: CreateFreightInput): ResponseEntity<FreightOutput> {
        val output = createFreightUseCase.execute(input)
        return ResponseEntity.status(HttpStatus.CREATED).body(output)
    }
}
package io.github.luishenriqueaguiar.freightsystem.application.usecase

import io.github.luishenriqueaguiar.freightsystem.application.dto.CreateFreightInput
import io.github.luishenriqueaguiar.freightsystem.application.dto.FreightOutput
import io.github.luishenriqueaguiar.freightsystem.application.dto.toDomain
import io.github.luishenriqueaguiar.freightsystem.application.dto.toOutput
import io.github.luishenriqueaguiar.freightsystem.domain.repository.FreightRepository

class CreateFreightUseCase(
    private val repository: FreightRepository
) {
    fun execute(input: CreateFreightInput): FreightOutput {
        return input.toDomain()
            .let { repository.save(it) }
            .toOutput()
    }
}
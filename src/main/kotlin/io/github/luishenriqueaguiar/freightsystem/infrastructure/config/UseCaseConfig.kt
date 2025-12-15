package io.github.luishenriqueaguiar.freightsystem.infrastructure.config

import io.github.luishenriqueaguiar.freightsystem.application.usecase.CreateFreightUseCase
import io.github.luishenriqueaguiar.freightsystem.domain.repository.FreightRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {

    @Bean
    fun createFreightUseCase(repository: FreightRepository): CreateFreightUseCase {
        return CreateFreightUseCase(repository)
    }
}

package io.github.luishenriqueaguiar.freightsystem.infrastructure.persistence.repository

import io.github.luishenriqueaguiar.freightsystem.infrastructure.persistence.entity.FreightJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpringDataFreightRepository : JpaRepository<FreightJpaEntity, UUID> {
}
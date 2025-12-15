package io.github.luishenriqueaguiar.freightsystem.infrastructure.persistence.repository

import io.github.luishenriqueaguiar.freightsystem.domain.entity.Freight
import io.github.luishenriqueaguiar.freightsystem.domain.repository.FreightRepository
import io.github.luishenriqueaguiar.freightsystem.domain.vo.FreightId
import io.github.luishenriqueaguiar.freightsystem.infrastructure.persistence.entity.FreightJpaEntity
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class FreightRepositoryImpl(
    private val jpaRepository: SpringDataFreightRepository
) : FreightRepository {

    override fun save(freight: Freight): Freight {
        val entity = FreightJpaEntity.from(freight)

        val savedEntity = jpaRepository.save(entity)

        return savedEntity.toDomain()
    }
    
    override fun findById(id: FreightId): Freight? {
        return jpaRepository.findById(id.value)
            .map { it.toDomain() }
            .getOrNull()
    }
}
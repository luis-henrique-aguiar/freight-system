package io.github.luishenriqueaguiar.freightsystem.infrastructure.persistence.entity

import io.github.luishenriqueaguiar.freightsystem.domain.entity.Freight
import io.github.luishenriqueaguiar.freightsystem.domain.entity.FreightStatus
import io.github.luishenriqueaguiar.freightsystem.domain.vo.FreightId
import io.github.luishenriqueaguiar.freightsystem.domain.vo.Money
import io.github.luishenriqueaguiar.freightsystem.domain.vo.Weight
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "freights")
class FreightJpaEntity(
    @Id
    val id: UUID,
    val description: String,
    val weight: Double,
    val price: BigDecimal,
    val status: String,
    val createdAt: LocalDateTime
) {

    protected constructor() : this(UUID.randomUUID(), "", 0.0, BigDecimal.ZERO, "", LocalDateTime.now())

    companion object {
        fun from(domain: Freight): FreightJpaEntity {
            return FreightJpaEntity(
                id = domain.id.value,
                description = domain.description,
                weight = domain.weight.valueInKg,
                price = domain.price.amount,
                status = domain.status.name,
                createdAt = domain.createdAt
            )
        }
    }

    fun toDomain(): Freight {
        return Freight(
            id = FreightId(this.id),
            description = this.description,
            weight = Weight(this.weight),
            price = Money(this.price),
            status = FreightStatus.valueOf(this.status),
            createdAt = this.createdAt
        )
    }
}
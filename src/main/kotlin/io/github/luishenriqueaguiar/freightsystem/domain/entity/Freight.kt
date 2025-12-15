package io.github.luishenriqueaguiar.freightsystem.domain.entity

import io.github.luishenriqueaguiar.freightsystem.domain.vo.FreightId
import io.github.luishenriqueaguiar.freightsystem.domain.vo.Money
import io.github.luishenriqueaguiar.freightsystem.domain.vo.Weight
import java.math.BigDecimal
import java.time.LocalDateTime

enum class FreightStatus {
    DRAFT, CALCULATED, CONFIRMED, DELIVERED
}

data class Freight(
    val id: FreightId = FreightId(),
    val description: String,
    val weight: Weight,
    val price: Money = Money.ZERO,
    val status: FreightStatus = FreightStatus.DRAFT,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun calculatePricing(tariffPerKg: Money): Freight {
        if (status != FreightStatus.DRAFT) {
            throw IllegalStateException("Cannot calculate price for a freight that is not in DRAFT")
        }

        val calculatedPrice = Money(
            tariffPerKg.amount.multiply(BigDecimal(weight.valueInKg))
        )

        return this.copy(
            price = calculatedPrice,
            status = FreightStatus.CALCULATED
        )
    }

    fun confirm(): Freight {
        if (status != FreightStatus.CALCULATED) {
            throw IllegalStateException("Freight must be calculated before confirmation")
        }

        return this.copy(status = FreightStatus.CONFIRMED)
    }
}
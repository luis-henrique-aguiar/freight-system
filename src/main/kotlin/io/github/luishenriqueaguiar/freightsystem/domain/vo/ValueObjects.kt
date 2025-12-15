package io.github.luishenriqueaguiar.freightsystem.domain.vo

import java.math.BigDecimal
import java.util.UUID

data class FreightId(val value: UUID = UUID.randomUUID()) {
    constructor(value: String) : this(UUID.fromString(value))
}

data class Money(val amount: BigDecimal) {
    init {
        require(amount >= BigDecimal.ZERO) { "Money cannot be negative" }
    }

    operator fun plus(other: Money): Money {
        return Money(this.amount.add(other.amount))
    }

    companion object {
        val ZERO = Money(BigDecimal.ZERO)
    }
}

data class Weight(val valueInKg: Double) {
    init {
        require(valueInKg > 0) { "Weight must be positive" }
    }
}
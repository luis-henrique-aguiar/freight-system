package io.github.luishenriqueaguiar.freightsystem.application.dto

import io.github.luishenriqueaguiar.freightsystem.domain.entity.Freight
import io.github.luishenriqueaguiar.freightsystem.domain.vo.Weight

data class CreateFreightInput(
    val description: String,
    val weight: Double
)

data class FreightOutput(
    val id: String,
    val status: String,
    val price: Double?
)

fun CreateFreightInput.toDomain(): Freight {
    return Freight(
        description = this.description,
        weight = Weight(this.weight)
    )
}

fun Freight.toOutput(): FreightOutput {
    return FreightOutput(
        id = this.id.value.toString(),
        status = this.status.name,
        price = this.price.amount.toDouble()
    )
}
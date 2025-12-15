package io.github.luishenriqueaguiar.freightsystem.domain.repository

import io.github.luishenriqueaguiar.freightsystem.domain.entity.Freight
import io.github.luishenriqueaguiar.freightsystem.domain.vo.FreightId

interface FreightRepository {

    fun findById(id: FreightId): Freight?

    fun save(freight: Freight): Freight

}
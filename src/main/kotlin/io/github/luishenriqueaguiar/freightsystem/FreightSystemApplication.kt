package io.github.luishenriqueaguiar.freightsystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FreightSystemApplication

fun main(args: Array<String>) {
	runApplication<FreightSystemApplication>(*args)
}

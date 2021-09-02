package com.bosha.domain.usecases

import com.bosha.domain.repositories.PizzaRepository

class GetCachePizzaUseCase(private val repository: PizzaRepository) {

    suspend operator fun invoke() = repository.getCachePizza()
}
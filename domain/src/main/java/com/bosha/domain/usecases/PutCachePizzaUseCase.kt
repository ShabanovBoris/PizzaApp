package com.bosha.domain.usecases

import com.bosha.domain.entities.PizzaItem
import com.bosha.domain.repositories.PizzaRepository

class PutCachePizzaUseCase(private val repository: PizzaRepository) {

    suspend operator fun invoke(list: List<PizzaItem>) = repository.putCachePizza(list)
}
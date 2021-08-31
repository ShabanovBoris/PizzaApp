package com.bosha.domain.usecases

import com.bosha.domain.entities.PizzaItem
import com.bosha.domain.repositories.PizzaRepository

class DeletePizzaUseCase (private val repository: PizzaRepository) {

    suspend operator fun invoke(pizzaItem: PizzaItem) = repository.deletePizza(pizzaItem)

}
package com.bosha.domain.usecases

import com.bosha.domain.repositories.PizzaRepository

class GetPizzaListUseCase (private val repository: PizzaRepository) {

     operator fun invoke() = repository.getPizzaList()

}
package com.bosha.data.mappers

import com.bosha.data.dto.PizzaApiResponse
import com.bosha.data.dto.PizzaCacheEntity
import com.bosha.domain.entities.PizzaItem
import javax.inject.Inject

class PizzaCacheMapper @Inject constructor() {

    fun PizzaCacheEntity.mapToPizzaItem() =
        PizzaItem(description, price.toString(), imageRes, title)

    fun PizzaItem.mapToPizzaCacheEntity() =
        PizzaCacheEntity(
            title = title,
            imageRes = imageResUrl,
            price = price.toInt(),
            description = description
        )

    fun List<PizzaCacheEntity>.mapToPizzaItemList(): List<PizzaItem> =
        map {
            it.mapToPizzaItem()
        }

    fun List<PizzaItem>.mapToPizzaCacheEntityList(): List<PizzaCacheEntity> =
        map {
            it.mapToPizzaCacheEntity()
        }

    operator fun <T> invoke(scope: PizzaCacheMapper.() -> T): T {
        return scope()
    }
}
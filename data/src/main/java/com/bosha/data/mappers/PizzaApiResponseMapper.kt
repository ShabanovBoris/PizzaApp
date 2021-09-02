package com.bosha.data.mappers

import com.bosha.data.dto.PizzaApiResponse
import com.bosha.domain.entities.PizzaItem
import javax.inject.Inject

class PizzaApiResponseMapper @Inject constructor() {

    fun PizzaApiResponse.mapToPizzaItem() =
        PizzaItem(description, price.toString(), imageResId, title)

    fun PizzaItem.mapToPizzaApiResponse() =
        PizzaApiResponse(price.toInt(), description, imageResUrl, title, uid = "")

    fun List<PizzaApiResponse>.mapToPizzaItemList(): List<PizzaItem> =
        map {
            it.mapToPizzaItem()
        }

    fun List<PizzaItem>.mapToPizzaApiResponseList(): List<PizzaApiResponse> =
        map {
            it.mapToPizzaApiResponse()
        }

    operator fun <T> invoke(scope: PizzaApiResponseMapper.() -> T): T {
        return scope()
    }
}
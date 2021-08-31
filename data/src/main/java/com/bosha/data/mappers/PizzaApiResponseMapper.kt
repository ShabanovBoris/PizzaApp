package com.bosha.data.mappers

import com.bosha.data.dto.PizzaApiResponse
import com.bosha.domain.entities.PizzaItem
import javax.inject.Inject

class PizzaApiResponseMapper @Inject constructor() {

    fun PizzaApiResponse.mapToPizzaItem() =
        PizzaItem(orderID, description, price, imageResId, title)

    fun PizzaItem.mapToPizzaApiResponse() =
        PizzaApiResponse(orderID, description, price, imageResId, title)

    fun List<PizzaApiResponse>.mapToPizzaItemList(): List<PizzaItem> =
        map {
            it.mapToPizzaItem()
        }

    fun List<PizzaItem>.mapToPizzaApiResponseList(): List<PizzaApiResponse> =
        map {
            it.mapToPizzaApiResponse()
        }


    operator fun <T>invoke(scope: PizzaApiResponseMapper.() -> T): T{
        return scope()
    }
}
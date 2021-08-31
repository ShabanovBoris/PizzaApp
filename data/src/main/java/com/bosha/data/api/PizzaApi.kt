package com.bosha.data.api

import com.bosha.data.BuildConfig
import com.bosha.data.dto.PizzaApiResponse
import retrofit2.http.*

interface PizzaApi {
    @GET("orders")
    suspend fun getPizzaList(): List<PizzaApiResponse>

    @Headers("Authorization: Bearer ${BuildConfig.THE_PIZZA_APIKEY}")
    @POST("orders")
    suspend fun putPizza(
        @Body habit: PizzaApiResponse
    )

    @DELETE("orders/{Order_ID}")
    suspend fun deletePizza(
       @Path("Order_ID") orderID: Int
    )
}
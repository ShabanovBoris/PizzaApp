package com.bosha.data.api

import com.bosha.data.BuildConfig
import com.bosha.data.dto.PizzaApiResponse
import retrofit2.http.*

interface PizzaApi {
    @Headers("Authorization:${BuildConfig.THE_PIZZA_APIKEY}")
    @GET("api/habit")
    suspend fun getPizzaList(): List<PizzaApiResponse>

    @Headers("Authorization:${BuildConfig.THE_PIZZA_APIKEY}")
    @PUT("api/habit")
    suspend fun putPizza(
        @Body habit: PizzaApiResponse
    )
}
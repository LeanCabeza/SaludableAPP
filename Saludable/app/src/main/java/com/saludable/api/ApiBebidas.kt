package com.saludable.api


import com.saludable.model.Bebida
import com.saludable.model.Drink
import retrofit2.Call
import retrofit2.http.GET


interface ApiBebidas {
    @GET("api/json/v1/1/random.php")
    fun getRandom(): Call<Bebida>?
}

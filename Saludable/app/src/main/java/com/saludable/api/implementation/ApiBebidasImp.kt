package com.saludable.api.implementation

import retrofit2.Call
import com.saludable.api.ApiBebidas
import com.saludable.model.Bebida
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiBebidasImp {

    private  fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.thecocktaildb.com/")
            .build()
    }

    fun getRandomBebida(): Call<Bebida>? {
        return getRetrofit().create(ApiBebidas::class.java).getRandom()
    }
}
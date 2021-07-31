package com.saludable.viewModel

import androidx.lifecycle.ViewModel
import com.saludable.api.implementation.ApiBebidasImp
import com.saludable.model.Bebida
import retrofit2.Call

class BebidaViewModel : ViewModel() {

    fun getBebidaRandom(): Call<Bebida>? {
        val api: ApiBebidasImp = ApiBebidasImp()
        return api.getRandomBebida()
    }

}
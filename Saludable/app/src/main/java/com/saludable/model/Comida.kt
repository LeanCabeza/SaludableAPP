package com.saludable.model

import java.io.Serializable

data class Comida(
    val tipoComida: String
    , val comidaPrincipal: String
    ,val comidaSecundaria :String
    , val bebida:String
    , val postre:String?= null
    , val tentacion:String?= null
    , val satisfecho:String?= null
    ,val fechayHora:String,
    val dniPaciente:String
    )
    : Serializable
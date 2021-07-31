package com.saludable.model

import java.io.Serializable

data class Paciente(
     val nombre: String
    , val apellido: String
     ,val dni :String
     , val sexo:String
    , val fechaNacimiento:String
    , val localidad:String
    , val usuario:String
    , val pass:String
    , val tipoTratamiento:String)
    : Serializable
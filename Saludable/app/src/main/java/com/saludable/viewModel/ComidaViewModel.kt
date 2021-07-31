package com.saludable.viewModel

import android.widget.RadioGroup
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class ComidaViewModel: ViewModel() {

    fun Guardar(
        rg_tipoComida: RadioGroup,
        comidaPrincipal: String,
        comidaSecundaria: String,
        bebida: String,
        rg_postre: RadioGroup,
        til_postre: TextInputEditText,
        rg_tentacion: RadioGroup,
        til_tentacion: TextInputEditText,
        rg_satisfecho: RadioGroup,
        usuarioPaciente: String,

        ):Boolean{

        if (comidaPrincipal.isNullOrBlank() ||
            comidaSecundaria.isNullOrBlank() ||
            bebida.isNullOrBlank()
        ){
            return false
        }else{
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val fechayHoraActual = sdf.format(Date())

            val db: FirebaseFirestore
            db = FirebaseFirestore.getInstance()
            db.collection("Comida").document().set(
                hashMapOf(
                    "tipoComida" to obtenerTipoComida(rg_tipoComida),
                    "comidaPrincipal" to comidaPrincipal,
                    "comidaSecundaria" to comidaSecundaria,
                    "bebida" to bebida,
                    "postre" to obtenerPostre(rg_postre,til_postre),
                    "tentacion" to obtenerTentacion(rg_tentacion,til_tentacion),
                    "satisfecho" to obtenerSatisfecho(rg_satisfecho),
                    "fechayHora" to fechayHoraActual,
                    "usuario" to usuarioPaciente
                )
            )
            return true
        }
    }

    private fun obtenerTipoComida(rgTipocomida: RadioGroup):String {
        if(rgTipocomida.getCheckedRadioButtonId() == com.saludable.R.id.rb_desayuno){
            return "Desayuno"
        }else if(rgTipocomida.getCheckedRadioButtonId() == com.saludable.R.id.rb_almuerzo){
            return "Almuerzo"
        }else if(rgTipocomida.getCheckedRadioButtonId() == com.saludable.R.id.rb_merienda){
        return "Merienda"
        }else{
            return "Cena"
        }
    }

    private fun obtenerPostre(rg_postre: RadioGroup,et_postre:TextInputEditText):String {
        if(rg_postre.getCheckedRadioButtonId() == com.saludable.R.id.rb_postre_si){
            return et_postre.text.toString()
        }else{
            return "No"
        }
    }

    private fun obtenerTentacion(rg_tentacion: RadioGroup,et_tentacion:TextInputEditText):String {
        if(rg_tentacion.getCheckedRadioButtonId() == com.saludable.R.id.rb_tentacion_si){
            return et_tentacion.text.toString()
        }else{
            return "No"
        }
    }

    private fun obtenerSatisfecho(rg_satisfecho: RadioGroup):String {
        if(rg_satisfecho.getCheckedRadioButtonId() == com.saludable.R.id.rb_satisfecho_si){
            return "Si"
        }else{
            return "No"
        }
    }


}
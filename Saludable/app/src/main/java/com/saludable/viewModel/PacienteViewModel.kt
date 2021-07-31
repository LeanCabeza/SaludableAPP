package com.saludable.viewModel

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.*
import com.saludable.view.Login
import com.saludable.view.MainActivity
import kotlin.coroutines.coroutineContext


class PacienteViewModel : ViewModel() {

    fun Alta(nombre: String,
             apellido: String,
             dni: String,
             rg_sexo: String,
             fechaNacimiento: String,
             localidad: String,
             usuario: String,
             pass: String,
             rg_tratamiento: String
    ):Boolean{

        if (nombre.isNullOrBlank() ||
            apellido.isNullOrBlank() ||
            dni.isNullOrBlank() ||
            fechaNacimiento.isNullOrBlank() ||
            localidad.isNullOrBlank() ||
            usuario.isNullOrBlank() ||
            pass.isNullOrBlank()){

                return false
        }else{
            val db:FirebaseFirestore
            db = FirebaseFirestore.getInstance()
            db.collection("Paciente").document(usuario).set(
                hashMapOf(
                    "nombre" to nombre,
                    "apellido" to apellido,
                    "dni" to dni,
                    "sexo" to rg_sexo,
                    "fechaNacimiento" to fechaNacimiento,
                    "localidad" to localidad,
                    "usuario" to usuario,
                    "pass" to pass,
                    "tipoTratamiento" to rg_tratamiento
                )
            )
            return true
        }
    }

     fun obtenerTratamiento(rg_tratamiento:RadioGroup): String {
        if(rg_tratamiento.getCheckedRadioButtonId() == com.saludable.R.id.rb_anorexia){
            return "Anorexia"
        }else if(rg_tratamiento.getCheckedRadioButtonId() == com.saludable.R.id.rb_bulimia){
            return "Bulimia"
        }else{
            return "Obesidad"
        }
    }

     fun obtenerSexo(rg_sexo:RadioGroup): String {
        if(rg_sexo.getCheckedRadioButtonId() == com.saludable.R.id.rb_masculino){
            return "Masculino"
        }else if(rg_sexo.getCheckedRadioButtonId() == com.saludable.R.id.rb_femenino){
            return "Femenino"
        }else{
            return "Otro"
        }
    }


    fun login(usuario: String, pass: String, login_info: TextView,view: View) {
        val db: FirebaseFirestore
        db = FirebaseFirestore.getInstance()
        db.collection("Paciente")
            .whereEqualTo("usuario", "$usuario")
            .whereEqualTo("pass", "$pass")
            .get()
            .addOnSuccessListener {
                var auxUser:String = ""

                for (aux in it){
                    auxUser = aux.data.toString()
                }
                if (auxUser.isNullOrBlank()){
                    Snackbar.make(view,"Usuario Invalido.", Snackbar.LENGTH_LONG).show()

                }else{
                    login_info.text="Validado"
                }
            }

    }

}



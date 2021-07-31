package com.saludable.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.saludable.R
import com.saludable.view.MainActivity
import com.saludable.viewModel.PacienteViewModel






class registrarse_frg : Fragment() {

    lateinit var paciente_vm: PacienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registrarse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nombre: TextInputEditText = view.findViewById(R.id.registro_et_nombre)
        val apellido: TextInputEditText = view.findViewById(R.id.registro_et_apellido)
        val dni: TextInputEditText = view.findViewById(R.id.registro_et_dni)
        val rg_sexo: RadioGroup = view.findViewById(R.id.rg_sexo)
        val fechaNacimiento: TextInputEditText = view.findViewById(R.id.registro_fecha_nac)
        val localidad: TextInputEditText = view.findViewById(R.id.registro_et_localidad)
        val usuario: TextInputEditText = view.findViewById(R.id.login_et_usuario)
        val pass: TextInputEditText = view.findViewById(R.id.login_et_pass)
        val rg_tratamiento: RadioGroup = view.findViewById(R.id.rg_tratamiento)
        val registrar: Button = view.findViewById(R.id.registro_btn_registrarse)

        paciente_vm = ViewModelProvider(this).get(PacienteViewModel::class.java)

        registrar.setOnClickListener(View.OnClickListener {

            if (paciente_vm.Alta(
                    nombre.text.toString(),
                    apellido.text.toString(),
                    dni.text.toString(),
                    paciente_vm.obtenerSexo(rg_sexo),
                    fechaNacimiento.text.toString(),
                    localidad.text.toString(),
                    usuario.text.toString(),
                    pass.text.toString(),
                    paciente_vm.obtenerTratamiento(rg_tratamiento)))
                {


                Snackbar.make(it,"Dado de alta con exito", Snackbar.LENGTH_LONG).show()
                    Handler().postDelayed({
                        val intent = Intent(activity, MainActivity::class.java)
                        intent.putExtra("usuarioRegistrado",usuario.text.toString())
                        startActivity(intent)
                    },500)
            }else{
                Snackbar.make(it,"Completa los campos que te faltan.", Snackbar.LENGTH_LONG).show()
            }
        })
    }




}
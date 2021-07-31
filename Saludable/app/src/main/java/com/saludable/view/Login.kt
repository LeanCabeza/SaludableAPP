package com.saludable.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.saludable.R
import com.saludable.fragments.registrarse_frg
import com.saludable.viewModel.PacienteViewModel
import kotlinx.coroutines.delay

class Login : AppCompatActivity() {

    lateinit var usuario: TextInputEditText
    lateinit var pass: TextInputEditText
    lateinit var login: Button
    lateinit var registrar: Button
    lateinit var paciente_vm: PacienteViewModel
    lateinit var login_info: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        inicializar()

        val register_frg = registrarse_frg()
        val manager = supportFragmentManager

        registrar.setOnClickListener(View.OnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frg_container,register_frg)
            transaction.commit()
        })

        login.setOnClickListener(View.OnClickListener {
            paciente_vm.login(usuario.text.toString(),pass.text.toString(),login_info,it)
        })

        login_info.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val intent = Intent(applicationContext,MainActivity::class.java)
                intent.putExtra("usuarioLoggeado",usuario.text.toString())
                startActivity(intent)
            }
        })


    }


    private fun inicializar() {
        login = findViewById(R.id.login_btn_login)
        registrar = findViewById(R.id.login_btn_registarse)
        usuario = findViewById(R.id.login_et_usuario)
        pass = findViewById(R.id.login_et_pass)
        paciente_vm = ViewModelProvider(this).get(PacienteViewModel::class.java)
        login_info =findViewById(R.id.tv_login_resultado)
    }
}
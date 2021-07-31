package com.saludable.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.saludable.R
import com.saludable.model.Bebida
import com.saludable.viewModel.ComidaViewModel
import com.saludable.viewModel.BebidaViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var rb_almuerzo: RadioButton
    lateinit var rb_cena: RadioButton
    lateinit var rb_desayuno: RadioButton
    lateinit var rb_merienda: RadioButton

    lateinit var rb_postre_si: RadioButton
    lateinit var rb_tentacion_si: RadioButton
    lateinit var rb_postre_no: RadioButton
    lateinit var rb_tentacion_no: RadioButton

    lateinit var rg_postre: RadioGroup
    lateinit var rg_tipoComida: RadioGroup
    lateinit var rg_tentacion: RadioGroup
    lateinit var rg_satisfecho: RadioGroup

    lateinit var til_postre: TextInputLayout
    lateinit var til_tentacion: TextInputLayout

    lateinit var et_postre: TextInputEditText
    lateinit var et_tentacion: TextInputEditText

    lateinit var comidaPrincipal: TextInputEditText
    lateinit var comidaSecundaria: TextInputEditText
    lateinit var bebida: TextInputEditText

    lateinit var guardar: Button

    lateinit var comida_vm: ComidaViewModel
    lateinit var bebida_vm: BebidaViewModel

    lateinit var nombreBebida: TextView
    lateinit var tragoImagen: ImageView
    lateinit var categoriaBebida: TextView



    lateinit var layout_trago:LinearLayout
    lateinit var layout_comida:LinearLayout
    lateinit var btn_beber:Button

    lateinit var userName: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializar()
        recuperarUsuario()

        rb_desayuno.setOnClickListener(View.OnClickListener {
            rg_postre.visibility = View.GONE
            til_postre.visibility = View.GONE
        })

        rb_almuerzo.setOnClickListener(View.OnClickListener {
            rg_postre.visibility = View.VISIBLE
        })

        rb_merienda.setOnClickListener(View.OnClickListener {
            rg_postre.visibility = View.GONE
            til_postre.visibility = View.GONE
        })

        rb_cena.setOnClickListener(View.OnClickListener {
            rg_postre.visibility = View.VISIBLE
        })

        rb_postre_si.setOnClickListener(View.OnClickListener {
            til_postre.visibility = View.VISIBLE
        })

        rb_postre_no.setOnClickListener(View.OnClickListener {
            til_postre.visibility = View.GONE
        })

        rb_tentacion_si.setOnClickListener(View.OnClickListener {
            til_tentacion.visibility = View.VISIBLE
        })

        rb_tentacion_no.setOnClickListener(View.OnClickListener {
            til_tentacion.visibility = View.GONE
        })

        btn_beber.setOnClickListener(View.OnClickListener {
            layout_comida.visibility = View.VISIBLE
            layout_trago.visibility = View.GONE
        })

        guardar.setOnClickListener(View.OnClickListener {

            if (comida_vm.Guardar(
                rg_tipoComida,
                comidaPrincipal.text.toString(),
                comidaSecundaria.text.toString(),
                bebida.text.toString(),
                rg_postre,
                et_postre,
                rg_tentacion,
                et_tentacion,
                rg_satisfecho,
                    userName.text.toString())){
                //Luego de guardar exitosamente limpio campos
                limpiarCampos()
                // Ofrezco el trago

                MaterialAlertDialogBuilder(this).setIcon(R.drawable.ic_trago).setTitle(resources.getString(R.string.titulo_trago)).setMessage(resources.getString(R.string.supporting_text_trago))
                    .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
                        Snackbar.make(it,"Trago Rechazado", Snackbar.LENGTH_LONG).show()
                    }
                    .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                        bebida_vm.getBebidaRandom()
                            ?.enqueue(object : Callback<Bebida> {
                                override fun onFailure(call: Call<Bebida>, t: Throwable) {
                                    Log.e("Error-Invoke-API", t.message.toString())
                                }
                                override fun onResponse(
                                    call: Call<Bebida>,
                                    response: Response<Bebida>
                                ) {
                                    if (response.body() != null) {
                                        val data = response.body()
                                        nombreBebida.text = data?.drinks?.get(0)?.strDrink
                                        categoriaBebida.text = data?.drinks?.get(0)?.strCategory
                                        Glide
                                            .with(it.context)
                                            .load(data?.drinks?.get(0)?.strDrinkThumb)
                                            .centerCrop()
                                            .into(tragoImagen)
                                        layout_trago.visibility = View.VISIBLE
                                        layout_comida.visibility = View.GONE
                                    }
                                }
                            })
                    }
                    .show()
            }else{
                Snackbar.make(it,"Complete los campos faltantes...", Snackbar.LENGTH_LONG).show()
            }
        })

    }

    private fun recuperarUsuario() {
        if(intent.getStringExtra("usuarioRegistrado").isNullOrBlank()){
            userName.text = intent.getStringExtra("usuarioLoggeado")
        }else{
            userName.text = intent.getStringExtra("usuarioRegistrado")
        }
    }

    private fun limpiarCampos() {
        comidaPrincipal.setText("")
        comidaSecundaria.setText("")
        bebida.setText("")
        et_tentacion.setText("")
        et_postre.setText("")
    }

    private fun inicializar() {
        rb_almuerzo = findViewById(R.id.rb_almuerzo)
        rb_cena = findViewById(R.id.rb_cena)
        rb_desayuno = findViewById(R.id.rb_desayuno)
        rb_merienda = findViewById(R.id.rb_merienda)

        rb_postre_si = findViewById(R.id.rb_postre_si)
        rb_postre_no = findViewById(R.id.rb_postre_no)
        rb_tentacion_si = findViewById(R.id.rb_tentacion_si)
        rb_tentacion_no = findViewById(R.id.rb_tentacion_no)

        rg_postre = findViewById(R.id.rg_postre)
        rg_tipoComida = findViewById(R.id.rg_tipoComida)
        rg_tentacion = findViewById(R.id.rg_tentacion)
        rg_satisfecho = findViewById(R.id.rg_satisfecho)


        til_postre= findViewById(R.id.til_postre)
        til_tentacion= findViewById(R.id.til_tentacion)

        et_postre= findViewById(R.id.m_et_postre)
        et_tentacion= findViewById(R.id.m_et_tentacion)

        nombreBebida= findViewById(R.id.trago_tv_nombre)
        tragoImagen = findViewById(R.id.trago_iv_imagen)
        categoriaBebida= findViewById(R.id.trago_tv_categoria)

        comidaPrincipal = findViewById(R.id.m_et_comidaPrincipal)
        comidaSecundaria = findViewById(R.id.m_et_comidaSecundaria)
        bebida = findViewById(R.id.m_et_bebida)
        guardar = findViewById(R.id.m_btn_guardar)
        comida_vm = ViewModelProvider(this).get(ComidaViewModel::class.java)
        bebida_vm = ViewModelProvider(this).get(BebidaViewModel::class.java)

        layout_trago=findViewById(R.id.layout_trago)
        layout_comida=findViewById(R.id.layout_comida)

        btn_beber=findViewById(R.id.btn_beber)

        userName=findViewById(R.id.m_tv_usuario)

    }
}
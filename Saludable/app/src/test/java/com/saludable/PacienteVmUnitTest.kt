package com.saludable

import android.widget.RadioGroup
import com.saludable.model.Paciente
import com.saludable.viewModel.PacienteViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito

class PacienteVmUnitTest {

    val paciente_vm:PacienteViewModel = Mockito.mock(PacienteViewModel::class.java)

    @Before
    fun iniciliazarElementos(){
        Mockito.`when`(paciente_vm
            .Alta(
            "Test",
            "Test",
            "1",
            "Masculino",
            "1/1/1",
            "Quilmes",
            "x",
            "x",
            "Tratamiento"))
            .thenReturn(true)
    }

    @Test
    fun alta() {
        assertEquals(
            paciente_vm
                .Alta(
                    "Test",
                    "Test",
                    "1",
                    "Masculino",
                    "1/1/1",
                    "Quilmes",
                    "x",
                    "x",
                    "Tratamiento")
            ,true)
    }
    

}
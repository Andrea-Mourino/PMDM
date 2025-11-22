package com.example.botontext

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    fun CambiarDeBoton1(){
        Datos.CurrentState.value= Estados.ESTADO2
        Datos.EnableBoton1.value
        Datos.EnableBoton2.value
    }

    fun CambiarDeBoton2(){
        Datos.CurrentState.value= Estados.ESTADO1
        Datos.EnableBoton1.value
        Datos.EnableBoton2.value

    }




}
package com.example.botontext

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow

object Datos {
    var CurrentState = MutableStateFlow(Estados.ESTADO1)
    var nuestroTexto= MutableStateFlow("Texto Inicio")
    var EnableBoton1= MutableStateFlow(CurrentState.value.Boton1)
    var EnableBoton2= MutableStateFlow(CurrentState.value.Boton2)



}

enum class Estados(val Boton1: Boolean, val Boton2: Boolean) {
    ESTADO1 (true, false),
    ESTADO2 (false, true)
}

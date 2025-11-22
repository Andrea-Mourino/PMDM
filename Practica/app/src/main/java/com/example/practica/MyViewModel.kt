package com.example.practica

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    val mensaje = Datos.mensaje
    val indiceJugador = Datos.indiceJugador

    // El jugador presiona un botón
    fun presionarBoton(color: Int) {
        val pasoActual = Datos.indiceJugador.value

        if (Datos.secuenciaJuego.isEmpty()) {
            mostrarSecuencia()
            return
        }

        if (Datos.secuenciaJuego[pasoActual] == color) {
            Datos.indiceJugador.value += 1
            if (Datos.indiceJugador.value >= Datos.secuenciaJuego.size) {
                Datos.mensaje.value = "¡Correcto! Se agrega un nuevo paso"
                Datos.agregarPaso()
                mostrarSecuencia()
            }
        } else {
            Datos.mensaje.value = "¡Fallaste! Reinicia el juego"
            Datos.reiniciar()
        }
    }

    // Muestra la secuencia iluminando los botones
    fun mostrarSecuencia() {
        CoroutineScope(Dispatchers.Main).launch {
            for (color in Datos.secuenciaJuego) {
                iluminarBoton(color)
                delay(500)
                apagarBotones()
                delay(200)
            }
        }
    }

    private fun iluminarBoton(color: Int) {
        when (color) {
            0 -> Datos.rojoDestello.value = true
            1 -> Datos.azulDestello.value = true
            2 -> Datos.verdeDestello.value = true
            3 -> Datos.amarilloDestello.value = true
        }
    }

    private fun apagarBotones() {
        Datos.rojoDestello.value = false
        Datos.azulDestello.value = false
        Datos.verdeDestello.value = false
        Datos.amarilloDestello.value = false
    }
}

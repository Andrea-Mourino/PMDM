package com.example.practica


import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

object Datos {
    var secuenciaJuego = mutableListOf<Int>() // Secuencia que genera el juego
    var indiceJugador = MutableStateFlow(0) // Paso actual del jugador
    var mensaje = MutableStateFlow("¡Empieza el juego!") // Mensaje en pantalla

    // Destellos de botones (true = iluminado)
    var rojoDestello = MutableStateFlow(false)
    var azulDestello = MutableStateFlow(false)
    var verdeDestello = MutableStateFlow(false)
    var amarilloDestello = MutableStateFlow(false)

    fun agregarPaso() {
        val siguiente = Random.nextInt(0, 4)
        secuenciaJuego.add(siguiente)
        indiceJugador.value = 0
        mensaje.value = "Repite la secuencia"
    }

    fun reiniciar() {
        secuenciaJuego.clear()
        indiceJugador.value = 0
        mensaje.value = "¡Nuevo juego! Presiona cualquier botón"
    }
}

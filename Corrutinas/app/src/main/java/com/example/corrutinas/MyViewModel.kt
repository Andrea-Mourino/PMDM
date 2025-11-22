package com.example.corrutinas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyViewModel : ViewModel() {

    private val _estado = MutableStateFlow(EstadoProceso.LISTO)
    val estado: StateFlow<EstadoProceso> get() = _estado

    private val _progreso = MutableStateFlow(0.0f)
    val progreso: StateFlow<Float> get() = _progreso

    private val _tamañoArchivo = MutableStateFlow(0.0f)
    val tamañoArchivo: StateFlow<Float> get() = _tamañoArchivo

    fun iniciarDescarga() {
        _estado.value = EstadoProceso.DESCARGANDO
        simularDescarga()
    }

    private fun simularDescarga() {
        // Genera tamaño aleatorio entre 50 y 300 KB
        _tamañoArchivo.value = Random.nextInt(50, 300).toFloat()
        val delayPorBloque = 200 + _tamañoArchivo.value * 3

        viewModelScope.launch {
            var progresoActual = 0.0f
            while (progresoActual < 100) {
                progresoActual += 10.0f
                _progreso.value = progresoActual
                delay(delayPorBloque.toLong())
            }

            _estado.value = EstadoProceso.TERMINADO

            // Reseteo automático después de 1 segundo
            delay(1000)
            _progreso.value = 0.0f
            _estado.value = EstadoProceso.LISTO
        }
    }
}

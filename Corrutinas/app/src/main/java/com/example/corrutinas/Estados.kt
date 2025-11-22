package com.example.corrutinas

enum class EstadoProceso(val botonActivo: Boolean, val mensajeEstado: String, val textoBoton: String) {
    LISTO(true, "LISTO", "INICIAR"),
    DESCARGANDO(false, "DESCARGANDO", "DESCARGANDO"),
    TERMINADO(false, "TERMINADO", "TERMINADO")
}

package com.example.corrutinas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PantallaPrincipal(viewModel: MyViewModel) {
    val estadoActual by viewModel.estado.collectAsState()
    val progreso by viewModel.progreso.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = estadoActual.mensajeEstado,
            style = MaterialTheme.typography.headlineMedium,
            color = if (estadoActual == EstadoProceso.DESCARGANDO) Color.Magenta else Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        BarraProgreso(progreso)

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { viewModel.iniciarDescarga() },
            enabled = estadoActual.botonActivo
        ) {
            Text(text = estadoActual.textoBoton)
        }
    }
}

@Composable
fun BarraProgreso(progreso: Float) {
    val fraccion = (progreso / 100f).coerceIn(0f, 1f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Progreso de descarga: ${progreso.toInt()}%")

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraccion)
                    .background(Color(0xFF009688))
            )
        }
    }
}

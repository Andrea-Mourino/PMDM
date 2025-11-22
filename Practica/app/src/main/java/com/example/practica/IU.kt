package com.example.practica



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class UI {
    companion object {
        @Composable
        fun ViewAll(myVM: MyViewModel) {
            val mensaje by myVM.mensaje.collectAsState()
            val rojoDestello by Datos.rojoDestello.collectAsState()
            val azulDestello by Datos.azulDestello.collectAsState()
            val verdeDestello by Datos.verdeDestello.collectAsState()
            val amarilloDestello by Datos.amarilloDestello.collectAsState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = mensaje, fontSize = 24.sp, modifier = Modifier.padding(16.dp))

                Spacer(modifier = Modifier.height(32.dp))

                Row {
                    SimonButton(Color.Red, rojoDestello) { myVM.presionarBoton(0) }
                    Spacer(modifier = Modifier.width(16.dp))
                    SimonButton(Color.Blue, azulDestello) { myVM.presionarBoton(1) }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    SimonButton(Color.Green, verdeDestello) { myVM.presionarBoton(2) }
                    Spacer(modifier = Modifier.width(16.dp))
                    SimonButton(Color.Yellow, amarilloDestello) { myVM.presionarBoton(3) }
                }
            }
        }

        @Composable
        fun SimonButton(baseColor: Color, iluminado: Boolean, onClick: () -> Unit) {
            val color = if (iluminado) baseColor.copy(alpha = 0.5f) else baseColor
            Button(
                onClick = onClick,
                modifier = Modifier.size(120.dp),
                colors = ButtonDefaults.buttonColors(containerColor = color)
            ) {}
        }
    }
}

package com.example.botontext

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



@Preview(showBackground = true)
@Composable
fun ViewAll() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val myVM = MyViewModel()
    Column {
    Button(enabled = Datos.CurrentState.collectAsState().value.Boton1,onClick = {myVM.CambiarDeBoton1()}) { //Aqui se crea el boton y el Text hace que le podamos poner un nombre al boton
        Text(text = Datos.nuestroTexto.collectAsState().value)
    }
    Button(enabled = Datos.CurrentState.collectAsState().value.Boton2,onClick = {myVM.CambiarDeBoton2()}) { //Aqui se crea el boton y el Text hace que le podamos poner un nombre al boton
        Text(text = Datos.nuestroTexto.collectAsState().value)

    }

    }
}


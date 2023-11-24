package com.acasloa946.p4recycledview.Screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Ejemplo1() {
    val listaDeNotas = mutableListOf<Int>(10,5)
    LazyColumn {
        items(listaDeNotas) {nota ->
            if (listaDeNotas.indexOf(nota) == 0) {
                Text(text = "Nota de Álvaro: $nota")
            }
            else if(listaDeNotas.indexOf(nota) == 1) {
                Text(text = "Nota de Guille: $nota")
            }
        }
        item { Text(text = "Fin") }
    }
}



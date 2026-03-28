package com.example.pizzagridapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Referencia al GridView
        val gvPizzas = findViewById<GridView>(R.id.gvPizzas)

        // 2. Lista de nombres de pizzas (puedes agregar más)
        val listaPizzas = arrayOf(
            "Pepperoni", "Hawaiana", "Margarita",
            "4 Quesos", "Vegetariana", "Suprema",
            "Americana", "BBQ Chicken", "Mexicana"
        )

        // 3. Adaptador para mostrar los nombres en la grilla
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPizzas)
        gvPizzas.adapter = adaptador

        // 4. Evento al hacer clic en una pizza
        gvPizzas.setOnItemClickListener { _, _, position, _ ->
            val pizzaSeleccionada = listaPizzas[position]
            Toast.makeText(this, "Pizza elegida: $pizzaSeleccionada", Toast.LENGTH_SHORT).show()
        }
    }
}
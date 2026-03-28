package com.example.multiconversor // Verifica que este sea tu paquete real

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los componentes del XML
        val etMonto = findViewById<EditText>(R.id.etMonto)
        val spinner = findViewById<Spinner>(R.id.spMonedas)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        // Configuración del Spinner
        val listaMonedas = arrayOf("Dólar", "Euro", "Libra", "Yen", "Real", "Peso MX", "Yuan", "Rupia")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaMonedas)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador

        btnCalcular.setOnClickListener {
            val montoStr = etMonto.text.toString()
            
            if (montoStr.isEmpty()) {
                Toast.makeText(this, "Ingresa un monto", Toast.LENGTH_SHORT).show()
            } else {
                val monto = montoStr.toDouble()
                val seleccion = spinner.selectedItem.toString()
                
                // Tasas de cambio aproximadas (1 Sol a X moneda)
                val tasa = when(seleccion) {
                    "Dólar" -> 0.27
                    "Euro" -> 0.25
                    "Libra" -> 0.21
                    "Yen" -> 40.2
                    "Real" -> 1.35
                    "Peso MX" -> 4.6
                    "Yuan" -> 1.95
                    "Rupia" -> 22.4
                    else -> 1.0
                }
                
                val resultado = monto * tasa
                Toast.makeText(this, "Son $resultado $seleccion", Toast.LENGTH_LONG).show()
            }
        }
    }
}
package com.example.moneda

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaración de variables para los componentes (Fase 4)
    private lateinit var cantidadInput: EditText
    private lateinit var radioSoles: RadioButton
    private lateinit var radioDolares: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de componentes
        cantidadInput = findViewById(R.id.editTextText)
        radioDolares = findViewById(R.id.radio0)
        radioSoles = findViewById(R.id.radio1)
    }

    // El nombre de esta función debe ser igual al que pusiste en el XML: android:onClick="miClicManejador"
    fun miClicManejador(view: View) {
        val textoCantidad = cantidadInput.text.toString()

        if (textoCantidad.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa una cantidad", Toast.LENGTH_SHORT).show()
            return
        }

        val cantidad = textoCantidad.toDouble()
        var resultado = 0.0

        // Lógica de conversión (Usando un tipo de cambio de ejemplo)
        if (radioDolares.isChecked) {
            // "A soles": Supongamos que 1 dólar = 3.80 soles
            resultado = cantidad * 3.80
            Toast.makeText(this, "El resultado en soles es: S/ $resultado", Toast.LENGTH_LONG).show()
        } else if (radioSoles.isChecked) {
            // "A dólares": Supongamos que 1 sol = 0.26 dólares
            resultado = cantidad / 3.80
            Toast.makeText(this, "El resultado en dólares es: $ $resultado", Toast.LENGTH_LONG).show()
        }
    }
}
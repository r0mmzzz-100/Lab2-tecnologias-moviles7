package com.example.proyectojavalab; // <-- REVISA QUE ESTO COINCIDA CON TU PROYECTO

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaración de objetos (En Java se hace fuera del onCreate)
    private EditText etNombre;
    private Button btnSaludar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de componentes
        etNombre = findViewById(R.id.etNombreJava);
        btnSaludar = findViewById(R.id.btnSaludarJava);
        tvResultado = findViewById(R.id.tvResultadoJava);

        // Evento Clic al estilo Java (Clase anónima)
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString().trim();

                if (nombre.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, escribe un nombre", Toast.LENGTH_SHORT).show();
                } else {
                    String mensaje = "¡Hola " + nombre + ", bienvenido a Java!";
                    tvResultado.setText(mensaje);
                    Toast.makeText(MainActivity.this, "Procesado correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
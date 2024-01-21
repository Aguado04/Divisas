package com.mcas2.recyclertutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Convertir extends AppCompatActivity {

    EditText editTextCantidad;
    RecyclerView recyclerView;
    int selectedPosition;
    Button btnConvertir;
    String selectedCurrency;
    double factorConversion = 1.0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertir);

        selectedCurrency = getIntent().getStringExtra("currency");
        recyclerView = findViewById(R.id.rvEventos);


        selectedPosition = getIntent().getIntExtra("position", -1);

        if (selectedPosition != -1) {

            String[] conversionRates = getResources().getStringArray(R.array.historic_event_date);
            factorConversion = Double.parseDouble(conversionRates[selectedPosition]);
        }

        editTextCantidad = findViewById(R.id.editTextCantidad);
        btnConvertir = findViewById(R.id.btnConvertir);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirDivisa();
            }
        });
    }

    private void convertirDivisa() {

        String cantidadEurosStr = editTextCantidad.getText().toString();

        if (cantidadEurosStr.isEmpty()) {
            Toast.makeText(this, "Ingrese una cantidad en euros", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double cantidadEuros = Double.parseDouble(cantidadEurosStr);


            double cantidadConvertida = cantidadEuros * factorConversion;


            Toast.makeText(this, "Cantidad convertida: " + cantidadConvertida, Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese una cantidad válida", Toast.LENGTH_SHORT).show();
        }
    }
}
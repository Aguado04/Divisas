package com.mcas2.recyclertutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<DivisasEventModel> divisasEventModels = new ArrayList<>();
    String selectedCurrency = "EUR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvEventos);
        setHistoricEventModels();

        DivisasEventRVAdapter adapter = new DivisasEventRVAdapter(
                this, divisasEventModels, selectedCurrency
        );

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setHistoricEventModels() {
        String[] eventNames = getResources().getStringArray(R.array.event_name);
        String[] eventPrices = getResources().getStringArray(R.array.event_price);
        int[] eventImages = {
                R.drawable.ic_dollar,
                R.drawable.ic_lira,
                R.drawable.ic_yuan,
                R.drawable.ic_libra,
                R.drawable.ic_rupia,
                R.drawable.ic_franco,
                R.drawable.ic_yen,
                R.drawable.ic_rublo
        };
        String[] eventConversionRates = getResources().getStringArray(R.array.event_price);

        for (int i = 0; i < eventNames.length; i++) {
            divisasEventModels.add(new DivisasEventModel(
                    eventNames[i],
                    eventPrices[i],
                    eventImages[i],
                    eventConversionRates[i]
            ));
        }
    }
}
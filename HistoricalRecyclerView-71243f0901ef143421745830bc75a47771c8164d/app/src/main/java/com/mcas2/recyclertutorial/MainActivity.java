    package com.mcas2.recyclertutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

    ArrayList<HistoricEventModel> historicEventModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvEventos);
        setHistoricEventModels();

        HistoricEventRVAdapter adapter = new HistoricEventRVAdapter(
                this, historicEventModels
        );

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    private void setHistoricEventModels(){
        String[] eventNames = getResources().getStringArray(R.array.historic_event_name);
        String[] eventDates = getResources().getStringArray(R.array.historic_event_date);
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


        for (int i = 0; i < eventNames.length; i++) {
            historicEventModels.add(new HistoricEventModel(
                    eventNames[i],
                    eventDates[i],
                    eventImages[i]
            ));
        }
    }
}
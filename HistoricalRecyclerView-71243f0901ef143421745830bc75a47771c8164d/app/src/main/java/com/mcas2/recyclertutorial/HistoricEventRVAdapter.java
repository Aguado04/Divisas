package com.mcas2.recyclertutorial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoricEventRVAdapter extends RecyclerView.Adapter<HistoricEventRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<HistoricEventModel> historicEventModels;
    String selectedCurrency;

    public HistoricEventRVAdapter(Context context, ArrayList<HistoricEventModel> historicEventModels, String selectedCurrency) {
        this.context = context;
        this.historicEventModels = historicEventModels;
        this.selectedCurrency = selectedCurrency;
    }

    @NonNull
    @Override
    public HistoricEventRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_row, parent, false);
        return new HistoricEventRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricEventRVAdapter.MyViewHolder holder, int position) {
        HistoricEventModel eventModel = historicEventModels.get(position);

        holder.tvName.setText(eventModel.getEventName());
        holder.tvDate.setText(eventModel.getEventDate());
        holder.ivImage.setImageResource(eventModel.getEventImage());
        holder.setConversionRate(eventModel.getConversionRate());
        holder.setOnClickListeners(position);
    }

    @Override
    public int getItemCount() {
        return historicEventModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvDate;
        ImageView ivImage;
        Button convertir;
        double conversionRate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.eventName);
            tvDate = itemView.findViewById(R.id.eventDate);
            ivImage = itemView.findViewById(R.id.eventImage);
            convertir = itemView.findViewById(R.id.convertir);
        }

        void setConversionRate(double rate) {
            conversionRate = rate;
        }

        void setOnClickListeners(int position) {
            convertir.setOnClickListener(this);
            convertir.setTag(position);
        }

        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            Intent intent = new Intent(context, Convertir.class);
            intent.putExtra("currency", selectedCurrency);
            intent.putExtra("position", position); // Enviar la posición como extra
            context.startActivity(intent);
        }
    }
}
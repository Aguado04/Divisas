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

    public HistoricEventRVAdapter(Context context, ArrayList<HistoricEventModel> historicEventModels) {
        this.context = context;
        this.historicEventModels = historicEventModels;
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
        holder.setOnClickLiseteners();
    }

    @Override
    public int getItemCount() {
        return historicEventModels.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvDate;
        ImageView ivImage;

        Button convertir;

        Context context;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            tvName = itemView.findViewById(R.id.eventName);
            tvDate = itemView.findViewById(R.id.eventDate);
            ivImage = itemView.findViewById(R.id.eventImage);

            convertir = itemView.findViewById(R.id.convertir);

        }

        void setOnClickLiseteners(){

            convertir.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, Convertir.class);
            context.startActivity(intent);
        }
    }
}

package com.example.a44602569838.spacekids.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a44602569838.spacekids.R;
import com.example.a44602569838.spacekids.model.Cricanca;

import java.util.ArrayList;

/**
 * Created by 44602569838 on 02/04/2018.
 */

public class RVAdapterCriancas extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Cricanca> cricancas;

    public RVAdapterCriancas(ArrayList<Cricanca> cricancas) {
        this.cricancas = cricancas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_criancas, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CriancasViewHolder extends RecyclerView.ViewHolder{

        public CriancasViewHolder(View itemView) {
            super(itemView);
        }
    }
}

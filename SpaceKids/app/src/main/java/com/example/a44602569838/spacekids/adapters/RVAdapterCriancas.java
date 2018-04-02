package com.example.a44602569838.spacekids.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a44602569838.spacekids.R;
import com.example.a44602569838.spacekids.game.Fase1;
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
        return new CriancasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CriancasViewHolder) {
            CriancasViewHolder criancasViewHolder = (CriancasViewHolder) holder;

            criancasViewHolder.nome.setText(cricancas.get(position).getNome());
            criancasViewHolder.idade.setText(cricancas.get(position).getIdade());
            criancasViewHolder.sexo.setText((cricancas.get(position).getSexo()));
            criancasViewHolder.foto.setImageResource(cricancas.get(position).getSexo().equals("masculino") ? R.drawable.avatares_02 : R.drawable.avatares_01);

            criancasViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), Fase1.class);
                    view.getContext().startActivity(i);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return cricancas.size();
    }

    public class CriancasViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView nome, idade, sexo;

        public CriancasViewHolder(View itemView) {
            super(itemView);

            foto = itemView.findViewById(R.id.foto);
            nome = itemView.findViewById(R.id.nomeCrianca);
            idade = itemView.findViewById(R.id.idadeCrianca);
            sexo = itemView.findViewById(R.id.sexoCrianca);

        }
    }
}

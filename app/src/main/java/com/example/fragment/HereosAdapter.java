package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HereosAdapter extends RecyclerView.Adapter<HereosAdapter.ViewHolder>{
    private Context context;
    private ArrayList<HeroesModel> heroesModels;

    public ArrayList<HeroesModel> getHeroesModels() {
        return heroesModels;
    }


    public HereosAdapter(Context context, ArrayList<HeroesModel> list) {
        this.context = context;
        this.heroesModels = list;
    }

    @NonNull
    @Override
    public HereosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pahlawan, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvHeroes.setText(getHeroesModels().get(position).getNamaPahlawan());
        holder.Details.setText(getHeroesModels().get(position).getDetailPahlawan());
        Glide.with(context).load(getHeroesModels().get(position).getGambarPahlawan()).into(holder.ivHeroes);
        holder.heroesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, detailsHeroes.class);
                pindah.putExtra("image", getHeroesModels().get(position).getGambarPahlawan());
                pindah.putExtra("judul",getHeroesModels().get(position).getNamaPahlawan());
                pindah.putExtra("isi", getHeroesModels().get(position).getDetailPahlawan());
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHeroes;
        private TextView tvHeroes;
        private TextView Details;
        private LinearLayout heroesLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHeroes = itemView.findViewById(R.id.imgHeroes);
            tvHeroes = itemView.findViewById(R.id.txtHeroes);
            Details = itemView.findViewById(R.id.details);
            heroesLayout = itemView.findViewById(R.id.layout);
        }
    }
}

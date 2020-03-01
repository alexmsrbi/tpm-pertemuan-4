package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailsHeroes extends AppCompatActivity {
    private TextView detailHeroes,nama;
    private ImageView imHeroes;
    String name,description;
    int imageData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_heroes);
        nama = findViewById(R.id.namaDetail);
        detailHeroes = findViewById(R.id.detailisi);
        imHeroes = findViewById(R.id.gambarDetail);
        imageData = getIntent().getIntExtra("image",0);
        name = getIntent().getStringExtra("judul");
        description = getIntent().getStringExtra("isi");
        imHeroes.setImageResource(imageData);
        nama.setText(name);
        detailHeroes.setText(description);
    }
}

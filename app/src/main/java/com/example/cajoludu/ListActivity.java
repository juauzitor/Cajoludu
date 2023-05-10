package com.example.cajoludu;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<Filme> filmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        filmes = new ArrayList<>();
        filmes.add(new Filme("Filme 1", (short) 2021));
        filmes.add(new Filme("Filme 2", (short) 2022));
        filmes.add(new Filme("Filme 3", (short) 2023));

        List<String> filmesInfo = new ArrayList<>();
        for (Filme filme : filmes) {
            String info = filme.getNome() + " - " + filme.getCurtidas() + " curtidas";
            filmesInfo.add(info);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filmesInfo);
        listView.setAdapter(adapter);
    }
}

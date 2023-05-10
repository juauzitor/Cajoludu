package com.example.cajoludu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<Filme> filmes;

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        DatabaseReference filmescon = reference.child("Filmes");

        filmescon.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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
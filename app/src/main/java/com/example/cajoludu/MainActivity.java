package com.example.cajoludu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrarUsuario(View view) {
        // Implemente a lógica para a opção "Cadastrar Usuário" aqui
    }

    public void login(View view) {
        // Implemente a lógica para a opção "Login" aqui
    }

    public void verListaFilmes(View view) {
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }
}

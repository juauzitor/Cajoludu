package com.example.cajoludu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    private EditText editTextMatricula;
    private EditText editTextNome;
    private EditText editTextTitulo1;
    private EditText editTextAno1;
    private EditText editTextTitulo2;
    private EditText editTextAno2;
    private EditText editTextTitulo3;
    private EditText editTextAno3;
    private EditText editTextTitulo4;
    private EditText editTextAno4;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        addDataToFirebase("1234","lasd");
        reference.child("usuario").child("145").child("nome").setValue("jor");

        // Inicializar os componentes da interface
        editTextMatricula = findViewById(R.id.editTextMatricula);
        editTextNome = findViewById(R.id.editTextNome);
        editTextTitulo1 = findViewById(R.id.editTextTitulo1);
        editTextAno1 = findViewById(R.id.editTextAno1);
        editTextTitulo2 = findViewById(R.id.editTextTitulo2);
        editTextAno2 = findViewById(R.id.editTextAno2);
        editTextTitulo3 = findViewById(R.id.editTextTitulo3);
        editTextAno3 = findViewById(R.id.editTextAno3);
        editTextTitulo4 = findViewById(R.id.editTextTitulo4);
        editTextAno4 = findViewById(R.id.editTextAno4);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);

        // Configurar o clique do botão Cadastrar
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter os valores digitados nos campos
                int matricula = Integer.parseInt(editTextMatricula.getText().toString());
                String nome = editTextNome.getText().toString();
                String titulo1 = editTextTitulo1.getText().toString();
                int ano1 = Integer.parseInt(editTextAno1.getText().toString());
                String titulo2 = editTextTitulo2.getText().toString();
                int ano2 = Integer.parseInt(editTextAno2.getText().toString());
                String titulo3 = editTextTitulo3.getText().toString();
                int ano3 = Integer.parseInt(editTextAno3.getText().toString());
                String titulo4 = editTextTitulo4.getText().toString();
                int ano4 = Integer.parseInt(editTextAno4.getText().toString());

                // Criar um objeto do tipo Usuario
                Usuario usuario = new Usuario(matricula, nome);
                Filme Filme1 = new Filme(titulo1, ano1);
                Filme Filme2 = new Filme(titulo2, ano2);
                Filme Filme3 = new Filme(titulo3, ano3);
                Filme Filme4 = new Filme(titulo4, ano4);

                // Salvar o objeto do tipo Usuario no Firebase
                addDataToFirebase(Integer.toString(usuario.getMatricula()), usuario.getNome());
                reference.child("usuario").child(Integer.toString(usuario.getMatricula())).child("nome").setValue(usuario.getNome());
                addFilmeToFirebase(Filme1, "1");
                addFilmeToFirebase(Filme2, "2");
                addFilmeToFirebase(Filme3, "3");
                addFilmeToFirebase(Filme4, "4");

            }
        });
    }

    public void addDataToFirebase(String matricula, String nome){
        reference.child("usuario").child(matricula).child("nome").setValue(nome);
    }
    public void addFilmeToFirebase(Filme filme, String a){
        reference.child("Filmes").child(a).child("titulo").setValue(filme.getNome());
        reference.child("Filmes").child(a).child("ano").setValue(filme.getAno());
        reference.child("Filmes").child(a).child("curtidas").setValue(filme.getCurtidas());
    }
}


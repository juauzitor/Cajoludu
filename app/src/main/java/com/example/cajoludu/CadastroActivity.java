package com.example.cajoludu;

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
                short ano1 = Short.parseShort(editTextAno1.getText().toString());
                String titulo2 = editTextTitulo2.getText().toString();
                short ano2 = Short.parseShort(editTextAno2.getText().toString());
                String titulo3 = editTextTitulo3.getText().toString();
                short ano3 = Short.parseShort(editTextAno3.getText().toString());
                String titulo4 = editTextTitulo4.getText().toString();
                short ano4 = Short.parseShort(editTextAno4.getText().toString());

                // Criar um objeto do tipo Usuario
                Usuario usuario = new Usuario(matricula, nome);
                Filme Filme1 = new Filme(titulo1, ano1);
                Filme Filme2 = new Filme(titulo2, ano2);
                Filme Filme3 = new Filme(titulo3, ano3);
                Filme Filme4 = new Filme(titulo4, ano4);

                // Salvar o objeto do tipo Usuario no Firebase
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child("usuario").child(String.valueOf(matricula)).child("nome").setValue(usuario.getNome())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(CadastroActivity.this, "Erro ao cadastrar usuário: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}


package com.example.cajoludu;


public class Filme {
    private String nome;
    private int ano;
    private int curtidas;

    public Filme(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
        this.curtidas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }
}

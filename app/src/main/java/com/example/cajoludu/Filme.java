package com.example.cajoludu;


public class Filme {
    private String nome;
    private short ano;
    private int curtidas;

    public Filme(String nome, short ano) {
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

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }
}

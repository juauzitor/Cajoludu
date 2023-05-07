package com.example.cajoludu;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Collection;

public class ListaDeFilmes extends ArrayList<Filme> {
    private final int maxSize;

    public ListaDeFilmes(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(Filme filme) {
        if (size() >= maxSize) {
            return false; // Limite de tamanho atingido, o filme não será adicionado
        }
        return super.add(filme);
    }

    @Override
    public void add(int index, Filme filme) {
        if (size() >= maxSize) {
            return; // Limite de tamanho atingido, o filme não será adicionado
        }
        super.add(index, filme);
    }

    @Override
    public boolean addAll(Collection<? extends Filme> filmes) {
        int totalSize = size() + filmes.size();
        if (totalSize > maxSize) {
            // Trunca a coleção para caber no limite de tamanho
            int elementosParaAdicionar = maxSize - size();
            ArrayList<Filme> sublist = (ArrayList<Filme>) new ArrayList<>(filmes).subList(0, elementosParaAdicionar);
            return super.addAll(sublist);
        }
        return super.addAll(filmes);
    }
}


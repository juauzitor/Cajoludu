package com.example.cajoludu;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ListaDeFilmesTest {

    @Test
    public void testAdd() {
        ListaDeFilmes listaFilmes = new ListaDeFilmes(3);
        Filme filme1 = new Filme("Filme 1", (short) 2010);
        Filme filme2 = new Filme("Filme 2", (short) 2009);
        Filme filme3 = new Filme("Filme 3", (short) 1995);

        // Adiciona filmes até o limite ser alcançado
        Assert.assertTrue(listaFilmes.add(filme1));
        Assert.assertTrue(listaFilmes.add(filme2));
        Assert.assertTrue(listaFilmes.add(filme3));

        // Tentativa de adicionar além do limite
        Filme filme4 = new Filme("Filme 4", (short) 1993);
        Assert.assertFalse(listaFilmes.add(filme4));
    }

    @Test
    public void testAddAtIndex() {
        ListaDeFilmes listaFilmes = new ListaDeFilmes(3);
        Filme filme1 = new Filme("Filme 1", (short) 2013);
        Filme filme2 = new Filme("Filme 2", (short) 2012);
        Filme filme3 = new Filme("Filme 3", (short) 2009);

        listaFilmes.add(filme1);
        listaFilmes.add(filme2);
        listaFilmes.add(filme3);

        // Tentativa de adicionar em um índice específico além do limite
        Filme filme4 = new Filme("Filme 4", (short) 2005);
        listaFilmes.add(1, filme4);

        Assert.assertEquals(filme1, listaFilmes.get(0));
        Assert.assertEquals(filme4, listaFilmes.get(1));
        Assert.assertEquals(filme2, listaFilmes.get(2));
    }

    @Test
    public void testAddAll() {
        ListaDeFilmes listaFilmes = new ListaDeFilmes(4);
        Filme filme1 = new Filme("Filme 1", (short) 2007);
        Filme filme2 = new Filme("Filme 2", (short) 2008);
        Filme filme3 = new Filme("Filme 3", (short) 1992);
        Filme filme4 = new Filme("Filme 4", (short) 1997 );
        Filme filme5 = new Filme("Filme 5", (short) 2003);

        // Adiciona filmes até o limite ser alcançado
        Assert.assertTrue(listaFilmes.addAll(Arrays.asList(filme1, filme2, filme3, filme4)));

        // Tentativa de adicionar uma coleção que excede o limite
        Assert.assertFalse(listaFilmes.addAll(Arrays.asList(filme5)));

        Assert.assertEquals(4, listaFilmes.size());
        Assert.assertTrue(listaFilmes.contains(filme1));
        Assert.assertTrue(listaFilmes.contains(filme2));
        Assert.assertTrue(listaFilmes.contains(filme3));
        Assert.assertTrue(listaFilmes.contains(filme4));
        Assert.assertFalse(listaFilmes.contains(filme5));
    }
}

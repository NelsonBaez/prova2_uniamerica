package br.uniamerica.prova2.test;

import br.uniamerica.prova2.dao.FilmeDao;
import br.uniamerica.prova2.model.Filme;

import java.sql.SQLException;
import java.util.List;

public class FilmeTest {
    public static void main(String[] args) throws SQLException {
        FilmeDao filmeDao = new FilmeDao();

        List<Filme> filmes = filmeDao.findAll();

        for (Filme filme : filmes){
            System.out.println(filme);
        }

    }
}

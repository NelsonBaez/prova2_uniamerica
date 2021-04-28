package br.uniamerica.prova2.dao;

import br.uniamerica.prova2.factory.ConnectionFactory;
import br.uniamerica.prova2.model.Filme;
import br.uniamerica.prova2.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao {
    private Connection connection;
    public FilmeDao(){
        this.connection = ConnectionFactory.getConnection();
        GeneroDao generoDao = new GeneroDao();
        this.criaTabelaFilme();
        this.criaTabelaFilmeGenero();

    }

    public void criaTabelaFilme(){
        String sql = "CREATE TABLE IF NOT EXISTS filmes ( " +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nome VARCHAR(255) NOT NULL, " +
                "data_lancamento DATE NOT NULL, " +
                "duracao INT NOT NULL " +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Filmes criada");
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public void criaTabelaFilmeGenero(){
        String sql = "CREATE TABLE IF NOT EXISTS filmes_generos ( " +
                "id_filme INT, " +
                "id_genero INT, " +
                "PRIMARY KEY (id_filme, id_genero), " +
                "FOREIGN KEY (id_filme) REFERENCES filmes(id), " +
                "FOREIGN KEY (id_genero) REFERENCES generos(id) " +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Filmes_Generos criada");
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public List<Genero> generos(Integer id_filme) throws SQLException {
        String sql = "SELECT * FROM filmes_generos where id_filme = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id_filme);

        ResultSet rs = stmt.executeQuery();

        List<Genero> generos = new ArrayList<>();

        while(rs.next()){
            Genero genero = new GeneroDao().find(rs.getInt(2));
            generos.add(genero);
        }

        rs.close();
        stmt.close();
        return generos;
    }

    public List<Filme> findAll() throws SQLException {
        String sql = "SELECT * FROM filmes";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Filme> filmes = new ArrayList<>();

        while(rs.next()){
            List<Genero> generos = this.generos(rs.getInt(1));
            filmes.add(new Filme(
                rs.getInt(1),
                rs.getString(2),
                rs.getDate(3).toLocalDate(),
                generos,
                rs.getInt(4)
            ));
        }

        rs.close();
        stmt.close();
        return filmes;
    }
}

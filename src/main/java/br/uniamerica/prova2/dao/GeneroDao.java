package br.uniamerica.prova2.dao;

import br.uniamerica.prova2.factory.ConnectionFactory;
import br.uniamerica.prova2.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {
    private Connection connection;
    public GeneroDao(){
        this.connection = ConnectionFactory.getConnection();
        this.criaTabelaGenero();
    }

    public void criaTabelaGenero(){
        String sql = "CREATE TABLE IF NOT EXISTS generos ( " +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nome VARCHAR(255) NOT NULL " +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Generos criada");
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public List<Genero> findAll() throws SQLException {
        String sql = "SELECT * FROM generos";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Genero> generos = new ArrayList<>();

        while(rs.next()){
            generos.add(new Genero(rs.getInt(1), rs.getString(2)));
        }

        rs.close();
        stmt.close();
        return generos;
    }

    public Genero find(Integer id){
        String sql = "SELECT * FROM generos WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            Genero genero = new Genero();

            if(rs.next()){
                genero.setId(rs.getInt(1));
                genero.setNome(rs.getString(2));
            }

            return genero;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

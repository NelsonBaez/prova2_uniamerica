package br.uniamerica.prova2.factory;


import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {


    public static Connection getConnection() {
        Connection conexao = null;

        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("unijobs");
            dataSource.setPassword("unijobs123");
            dataSource.setServerName("localhost");
            dataSource.setServerTimezone("UTC");
            dataSource.setDatabaseName("prova2");
            conexao = dataSource.getConnection();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "conexao" + erro.getMessage());
            System.out.println("Conexão com o banco Falhou");
        }
        return conexao;
    }
}
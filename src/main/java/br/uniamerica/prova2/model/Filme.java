package br.uniamerica.prova2.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private LocalDate data_lancamento;
    private List<Genero> generos;
    private Integer duracao;

    public Filme(String nome, LocalDate data_lancamento, List<Genero> generos, Integer duracao) {
        this.nome = nome;
        this.data_lancamento = data_lancamento;
        this.generos = generos;
        this.duracao = duracao;
    }

    public Filme(Integer id, String nome, LocalDate data_lancamento, List<Genero> generos, Integer duracao) {
        this.id = id;
        this.nome = nome;
        this.data_lancamento = data_lancamento;
        this.generos = generos;
        this.duracao = duracao;
    }

    public Filme(Integer id, String nome, LocalDate data_lancamento, Integer duracao) {
        this.id = id;
        this.nome = nome;
        this.data_lancamento = data_lancamento;
        this.duracao = duracao;
    }

    public Filme(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(LocalDate data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data_lancamento=" + data_lancamento +
                ", generos=" + generos +
                ", duracao=" + duracao +
                '}';
    }
}

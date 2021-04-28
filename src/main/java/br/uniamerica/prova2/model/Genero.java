package br.uniamerica.prova2.model;

public class Genero {
    private Integer id;
    private String nome;

    public Genero(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Genero(String nome) {
        this.nome = nome;
    }

    public Genero() {
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

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

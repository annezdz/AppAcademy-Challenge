package com.premiersoft.appacademy.appacademy.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "candidatos")
public class Candidato {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String vaga;

    @Column(nullable = false)
    private int idade;

    @Column(nullable = false)
    private String estado;

    @Deprecated
    public Candidato() { }

    public Candidato(String nome, String vaga, int idade, String estado) {
        this.nome = nome;
        this.vaga = vaga;
        this.idade = idade;
        this.estado = estado;
    }

    public Candidato(String frase){

        var splitted = frase.split(";");
        this.nome = splitted[0];
        this.vaga = splitted[1];
        this.idade = Integer.parseInt(splitted[2].split(" ")[0]);
        this.estado = splitted[3];
    }

    public int getId(){return id;}

    public String getNome() { return nome; }

    public String getVaga() {
        return vaga;
    }

    public int getIdade() {
        return idade;
    }

    public String getEstado() {
        return estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return Objects.equals(nome, candidato.nome) && Objects.equals(vaga, candidato.vaga) && Objects.equals(idade, candidato.idade) && Objects.equals(estado, candidato.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, vaga, idade, estado);
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", vaga='" + vaga + '\'' +
                ", idade=" + idade +
                ", estado='" + estado + '\'' +
                '}';
    }
}

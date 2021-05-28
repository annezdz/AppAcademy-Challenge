package com.premiersoft.appacademy.appacademy.model;

//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
////@Table(name = "candidatos")
public class Candidato {


    private String nome;
    private String vaga;
    private String idade;
    private String estado;

    @Deprecated
    public Candidato() { }

    public Candidato(String nome, String vaga, String idade, String estado) {
        this.nome = nome;
        this.vaga = vaga;
        this.idade = idade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public String getVaga() {
        return vaga;
    }

    public String getIdade() {
        return idade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", vaga='" + vaga + '\'' +
                ", idade='" + idade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

package com.premiersoft.appacademy.appacademy.dto;

import com.premiersoft.appacademy.appacademy.model.Candidato;

public class CandidatoRequestDto {

    private String nome;
    private String vaga;
    private int idade;
    private String estado;

    @Deprecated
    public CandidatoRequestDto(){}

    public CandidatoRequestDto(String nome, String vaga, int idade, String estado) {
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

    public int getIdade() {
        return idade;
    }

    public String getEstado() {
        return estado;
    }

    public Candidato toModel(){
        return new Candidato(nome,vaga,idade,estado);
    }
}

package com.premiersoft.appacademy.appacademy.dto;

import com.premiersoft.appacademy.appacademy.model.Candidato;

public class CandidatoResponseDto {

    private int id;
    private String nome;
    private String vaga;
    private int idade;
    private String estado;

    public CandidatoResponseDto(Candidato candidato){
        this.id = candidato.getId();
        this.nome = candidato.getNome();
        this.vaga = candidato.getVaga();
        this.idade = candidato.getIdade();
        this.estado = candidato.getEstado();
    }

    public int getId() {
        return id;
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
}

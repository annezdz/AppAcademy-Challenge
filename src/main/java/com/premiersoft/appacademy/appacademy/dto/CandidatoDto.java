package com.premiersoft.appacademy.appacademy.dto;

public class CandidatoDto {

    private int id;
    private String nome;
    private String vaga;
    private int idade;
    private String estado;


    @Deprecated
    public CandidatoDto(){}


    public CandidatoDto(int id, String frase){
        var splitted = frase.split(";");
        this.id = id;
        this.nome= splitted[0];
        this.vaga = splitted[1];
        this.idade = Integer.parseInt(splitted[2].split(" ")[0]);
        this.estado = splitted[3];
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

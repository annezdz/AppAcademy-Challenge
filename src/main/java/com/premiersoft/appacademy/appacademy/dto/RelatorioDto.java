package com.premiersoft.appacademy.appacademy.dto;

import com.premiersoft.appacademy.appacademy.model.Candidato;

public class RelatorioDto {

    private Candidato candidato;
    private Double percentualAndroid;
    private Double percentualQA;
    private Double percentualIOS;
    private Integer idadeMediaQA;
    private Integer estadosDistintos;

    @Deprecated
    public RelatorioDto() { }

    public RelatorioDto(Candidato candidato, Double percentualAndroid, Double percentualQA,
                        Double percentualIOS, Integer idadeMediaQA, Integer estadosDistintos) {
        this.candidato = candidato;
        this.percentualAndroid = percentualAndroid;
        this.percentualQA = percentualQA;
        this.percentualIOS = percentualIOS;
        this.idadeMediaQA = idadeMediaQA;
        this.estadosDistintos = estadosDistintos;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public Double getPercentualAndroid() {
        return percentualAndroid;
    }

    public Double getPercentualQA() {
        return percentualQA;
    }

    public Double getPercentualIOS() {
        return percentualIOS;
    }

    public Integer getIdadeMediaQA() {
        return idadeMediaQA;
    }

    public Integer getEstadosDistintos() {
        return estadosDistintos;
    }
}

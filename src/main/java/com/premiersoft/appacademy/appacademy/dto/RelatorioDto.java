package com.premiersoft.appacademy.appacademy.dto;

import com.premiersoft.appacademy.appacademy.model.Candidato;
import org.hibernate.mapping.List;

public class RelatorioDto {

    private Long id;
    private Candidato candidato;
//    private Double percentualAndroid;
//    private Double percentualQA;
//    private Double percentualIOS;
    private Integer idadeMediaQA;
    private Integer estadosDistintos;
    private List getPercentual;

    @Deprecated
    public RelatorioDto() { }

    public RelatorioDto(Long id, Candidato candidato, Integer idadeMediaQA, Integer estadosDistintos, List getPercentual) {
        this.id = id;
        this.candidato = candidato;
        this.idadeMediaQA = idadeMediaQA;
        this.estadosDistintos = estadosDistintos;
        this.getPercentual = getPercentual;
    }

    public Candidato getCandidato() {
        return candidato;
    }

//    public Double getPercentualAndroid() {
//        return percentualAndroid;
//    }
//
//    public Double getPercentualQA() {
//        return percentualQA;
//    }
//
//    public Double getPercentualIOS() {
//        return percentualIOS;
//    }

    public Integer getIdadeMediaQA() {
        return idadeMediaQA;
    }

    public Integer getEstadosDistintos() {
        return estadosDistintos;
    }

    public List getGetPercentual() {
        return getPercentual;
    }

    public Long getId() {
        return id;
    }
}

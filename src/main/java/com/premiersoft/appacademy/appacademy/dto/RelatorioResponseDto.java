package com.premiersoft.appacademy.appacademy.dto;

import com.premiersoft.appacademy.appacademy.model.Candidato;
import org.hibernate.mapping.List;

public class RelatorioResponseDto {

    private final Long id;
    private final Candidato candidato;
    private final Integer idadeMediaQA;
    private final Integer estadosDistintos;
    private final List getPercentual;


    public RelatorioResponseDto(RelatorioDto relatorioDto) {
        this.candidato = relatorioDto.getCandidato();
        this.id = relatorioDto.getId();
        this.idadeMediaQA = relatorioDto.getIdadeMediaQA();
        this.estadosDistintos = relatorioDto.getEstadosDistintos();
        this.getPercentual = relatorioDto.getGetPercentual();
    }

    public Long getId() {
        return id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public Integer getIdadeMediaQA() {
        return idadeMediaQA;
    }

    public Integer getEstadosDistintos() {
        return estadosDistintos;
    }

    public List getGetPercentual() {
        return getPercentual;
    }
}

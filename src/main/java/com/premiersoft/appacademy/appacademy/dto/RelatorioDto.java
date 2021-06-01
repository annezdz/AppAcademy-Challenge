package com.premiersoft.appacademy.appacademy.dto;

import com.premiersoft.appacademy.appacademy.model.Candidato;

import java.util.*;

public class RelatorioDto {

    private Integer idadeMediaQA;
    private Integer estadosDistintos;
    private List<Double> getPercentual = new ArrayList<>();
    private List<Candidato> findTeacheriOS = new ArrayList<>();
    private List<Candidato> findTeacherAndroid = new ArrayList<>();
    private Map<String,Long> estadosComMenosCandidatos = new LinkedHashMap<>();
    private final List<String> vagas = Arrays.asList("QA", "Android", "iOS");

    public RelatorioDto(Integer idadeMediaQA, Integer estadosDistintos, List<Double> getPercentual,
                        List<Candidato> findTeacheriOS, List<Candidato> findTeacherAndroid,
                        Map<String, Long> estadosComMenosCandidatos) {

        this.idadeMediaQA = idadeMediaQA;
        this.estadosDistintos = estadosDistintos;
        this.getPercentual = getPercentual;
        this.findTeacheriOS = findTeacheriOS;
        this.findTeacherAndroid = findTeacherAndroid;
        this.estadosComMenosCandidatos = estadosComMenosCandidatos;
    }



    public Integer getIdadeMediaQA() {
        return idadeMediaQA;
    }

    public Integer getEstadosDistintos() {
        return estadosDistintos;
    }

    public List<Double> getGetPercentual() {
        return getPercentual;
    }

    public List<Candidato> getFindTeacheriOS() {
        return findTeacheriOS;
    }

    public List<Candidato> getFindTeacherAndroid() {
        return findTeacherAndroid;
    }

    public Map<String, Long> getEstadosComMenosCandidatos() {
        return estadosComMenosCandidatos;
    }

    @Override
    public String toString() {
        return "Proporção de candidatos por vaga: \n" +
                "Android: " + getPercentual.get(1) + "\n" +
                "iOS: " + getPercentual.get(2) + "\n" +
                "QA: " + getPercentual.get(0) + "\n\n" +
                "Idade média dos candidatos de QA: " + idadeMediaQA + " anos\n\n" +
                "Número de estados distintos presentes na lista: " + estadosDistintos + "\n\n" +
                "Rank dos 4 estados com menos ocorrências:" + estadosComMenosCandidatos + "\n\n" +
                "Instrutor de Android: " + findTeacherAndroid.get(0).getNome() + "\n\n" +
                "Instrutor de iOS: " + findTeacheriOS.get(0).getNome();
    }
}

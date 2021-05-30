package com.premiersoft.appacademy.appacademy.service;

import com.premiersoft.appacademy.appacademy.model.Candidato;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface CandidatoService {


    List<Candidato> saveAll(String file) throws FileNotFoundException;
    double getPercentual(String vaga);
    double idadeMediaQA(String vaga);
    int estadosDistintos();
    Map<String, Long> estadosComMenosCandidatos();
    List<Candidato> listaOrdenada();
}

package com.premiersoft.appacademy.appacademy.service;

import com.premiersoft.appacademy.appacademy.handler.LerCsvFiles;
import com.premiersoft.appacademy.appacademy.model.Candidato;
import com.premiersoft.appacademy.appacademy.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

@Service
public class CandidatoServiceImpl  implements CandidatoService{

    private final LerCsvFiles lerCsvFiles;
    private final CandidatoRepository repository;

    public CandidatoServiceImpl(LerCsvFiles lerCsvFiles, CandidatoRepository repository) {
        this.lerCsvFiles = lerCsvFiles;
        this.repository = repository;
    }


    public List<Candidato> saveAll(String file) throws FileNotFoundException {
        var listCandidatos = lerCsvFiles.readCsvLineByLine(file);
        var add = listCandidatos.stream().map(Candidato::new).collect(Collectors.toList());
        return repository.saveAll(add);
    }


    public double getPercentual(String vaga) {
        int totalCandidatos = repository.findAll().size();
        int qtd = repository.findAllByVaga(vaga).size();
        return (Math.round((double)qtd/totalCandidatos * 100));
    }


    public double idadeMediaQA(String vaga){
        var ageList = repository.findAllByVaga(vaga).stream()
                .map(Candidato::getIdade)
                .collect(Collectors.toList()).stream()
                .reduce(0, Integer::sum) ;

        return (double) ageList / repository.findAllByVaga(vaga).size();
    }

    public int estadosDistintos(){
        return (int) repository.findAll().stream()
                .map(Candidato::getEstado)
                .distinct().count();
    }

    public Map<String, Long> estadosComMenosCandidatos(){
        var estadoList =repository.findAll().stream()
                .collect(Collectors.groupingBy(Candidato::getEstado, counting()));

        return estadoList;
        
//        var estadoList = repository.findAll().stream()
//                .map(Candidato::getEstado)
//                .collect(Collectors.groupingBy(Candidato::getEstado));
//
    }





}

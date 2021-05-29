package com.premiersoft.appacademy.appacademy.service;

import com.premiersoft.appacademy.appacademy.handler.LerCsvFiles;
import com.premiersoft.appacademy.appacademy.model.Candidato;
import com.premiersoft.appacademy.appacademy.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoServiceImpl  implements CandidatoService{

    private final LerCsvFiles lerCsvFiles;
    private final CandidatoRepository repository;

    public CandidatoServiceImpl(LerCsvFiles lerCsvFiles, CandidatoRepository repository) {
        this.lerCsvFiles = lerCsvFiles;
        this.repository = repository;
    }


    @Override
    public List<Candidato> saveAll(String file) throws FileNotFoundException {
        var listCandidatos = lerCsvFiles.readCsvLineByLine(file);
        var add = listCandidatos.stream().map(Candidato::new).collect(Collectors.toList());
        return repository.saveAll(add);
    }
}

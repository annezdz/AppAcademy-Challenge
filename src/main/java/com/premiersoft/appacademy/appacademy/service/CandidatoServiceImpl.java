package com.premiersoft.appacademy.appacademy.service;

import com.premiersoft.appacademy.appacademy.dto.RelatorioDto;
import com.premiersoft.appacademy.appacademy.handler.CriarCsvFiles;
import com.premiersoft.appacademy.appacademy.handler.LerCsvFiles;
import com.premiersoft.appacademy.appacademy.model.Candidato;
import com.premiersoft.appacademy.appacademy.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CandidatoServiceImpl  implements CandidatoService{

    private final LerCsvFiles lerCsvFiles;
    private final CandidatoRepository repository;
    private final CriarCsvFiles criarCsvFiles;

    public CandidatoServiceImpl(LerCsvFiles lerCsvFiles, CandidatoRepository repository, CriarCsvFiles criarCsvFiles) {
        this.lerCsvFiles = lerCsvFiles;
        this.repository = repository;
        this.criarCsvFiles = criarCsvFiles;
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


    public int idadeMediaQA(String vaga){
        var ageList = repository.findAllByVaga(vaga).stream()
                .map(Candidato::getIdade)
                .collect(Collectors.toList()).stream()
                .reduce(0, Integer::sum) ;

        return ageList / repository.findAllByVaga(vaga).size();
    }

    public int estadosDistintos(){
        return (int) repository.findAll().stream()
                .map(Candidato::getEstado)
                .distinct().count();
    }

    public Map<String, Long> estadosComMenosCandidatos(){
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(Candidato::getEstado, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                .limit(4)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    }
    
    public List<Candidato> listaOrdenada(){
        return repository.findAll().stream().sorted(Comparator.comparing(Candidato::getNome))
                .collect(Collectors.toList());
    }

    public void gravarCsv() throws IOException {
        var gravar = listaOrdenada();
        criarCsvFiles.gravarCsv(gravar);
    }

    public List<Candidato> filtersByCriteria(){
        return repository.findAll()
                .stream()
                .filter(c -> c.getEstado().equals("SC")
                        && c.getIdade() >= 21
                        && c.getIdade() < 31
                        && c.getIdade() % 2 != 0)
                .collect(Collectors.toList());
    }

    public List<Candidato> findTeacheriOS(){

        return filtersByCriteria().stream()
                .filter(item -> item.getNome().split(" ")[1].startsWith("V"))
                .collect(Collectors.toList());
    }

    public List<Candidato> findTeacherAndroid(){

        return filtersByCriteria()
                .stream()
                .filter(item -> item.getNome().split(" ")[0].endsWith("o"))
                .filter(a -> Pattern.compile("[aeiouAEIOU????????????????????????????????]")
                        .matcher(a.getNome().split(" ")[0]).results().count() == 3)
                .collect(Collectors.toList());
    }

    // vagas = Arrays.asList("QA", "Android", "iOS");

    public RelatorioDto buildRelatorio(){

        List<String> vagas = Arrays.asList("QA", "Android", "iOS");

        return new RelatorioDto(
                idadeMediaQA(vagas.get(0)),
                estadosDistintos(),
                vagas.stream().map(this::getPercentual).collect(Collectors.toList()),
                findTeacheriOS(),
                findTeacherAndroid(),
                estadosComMenosCandidatos()
                );
    }
}

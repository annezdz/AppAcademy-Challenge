package com.premiersoft.appacademy.appacademy.controller;

import com.premiersoft.appacademy.appacademy.handler.LerCsvFiles;
import com.premiersoft.appacademy.appacademy.repository.CandidatoRepository;
import com.premiersoft.appacademy.appacademy.service.CandidatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class CandidatoController {

    private final LerCsvFiles lerCsvFiles;
    private final CandidatoService service;


    public CandidatoController(LerCsvFiles lerCsvFiles, CandidatoRepository repository, CandidatoService service) {
        this.lerCsvFiles = lerCsvFiles;
        this.service = service;
    }

//
//    @GetMapping("api/csv")
//    public ResponseEntity<?> lerArquivoEPopularBanco(@RequestParam String filename) throws FileNotFoundException {
//       return ResponseEntity.ok(service.saveAll(filename));
//    }

    @GetMapping("/porc")
    public ResponseEntity<?> getPorcentagem (@RequestParam String vaga){
        return ResponseEntity.ok(service.getPercentual(vaga));
    }

    @GetMapping("/idade/{vaga}")
    public ResponseEntity<?> getAverageAgeByVaga(@PathVariable("vaga") String vaga) {
        return ResponseEntity.ok(service.idadeMediaQA(vaga));
    }

    @GetMapping("/estados")
    public ResponseEntity<?> getEstados(){
        return ResponseEntity.ok(service.estadosDistintos());
    }

    @GetMapping("/ultimos")
    public ResponseEntity<?> estadosComMenosCandidatos(){
        return ResponseEntity.ok(service.estadosComMenosCandidatos());
    }

    @GetMapping("/gravarcsv")
    public ResponseEntity<?> listaOrdenada() throws IOException {
        service.gravarCsv();
        return ResponseEntity.ok().build();
    }

    @GetMapping("instrutores")
    public ResponseEntity<?> findTeachers(){
        return ResponseEntity.ok(service.filtersByCriteria());
    }

    @GetMapping("ios")
    public ResponseEntity<?> findTeacheriOS(){
        return ResponseEntity.ok(service.findTeacheriOS());
    }


}

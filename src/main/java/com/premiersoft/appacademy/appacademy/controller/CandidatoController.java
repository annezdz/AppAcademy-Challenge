package com.premiersoft.appacademy.appacademy.controller;

import com.premiersoft.appacademy.appacademy.handler.LerCsvFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatoController {

    private final LerCsvFiles lerCsvFiles;

    public CandidatoController(LerCsvFiles lerCsvFiles) {
        this.lerCsvFiles = lerCsvFiles;
    }

    @GetMapping("api/lista")
    public ResponseEntity<?> ler(){
       return ResponseEntity.ok(lerCsvFiles.readCsvLineByLine("candidatos.csv"));
    }
}

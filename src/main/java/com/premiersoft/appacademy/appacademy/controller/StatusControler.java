package com.premiersoft.appacademy.appacademy.controller;

import com.premiersoft.appacademy.appacademy.utils.LerCsvFiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class StatusControler {

    @GetMapping("api/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("api/lista")
    public List teste() throws IOException {
        LerCsvFiles ler = new LerCsvFiles();
        return ler.lerCsv();
    }
}

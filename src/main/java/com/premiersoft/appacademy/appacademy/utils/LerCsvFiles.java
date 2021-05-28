package com.premiersoft.appacademy.appacademy.utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.premiersoft.appacademy.appacademy.model.Candidato;


public class LerCsvFiles {

    public List<Candidato> lerCsv() throws IOException {

        //String path = "c:\\repos\\app-academy\\candidatos.csv";
        Reader reader = Files.newBufferedReader(Paths.get("c:\\repos\\app-academy\\candidatos.csv"));

        CsvToBean<Candidato> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Candidato.class)
                .build();

        List<Candidato> candidatos = csvToBean.parse();

        for(Candidato candidato : candidatos)
            System.out.println(candidato);
        return candidatos;
    }
}

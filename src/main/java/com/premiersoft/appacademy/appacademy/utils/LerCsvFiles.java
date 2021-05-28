package com.premiersoft.appacademy.appacademy.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.premiersoft.appacademy.appacademy.model.Candidato;
import org.springframework.stereotype.Component;

@Component
public class LerCsvFiles {

    public List<String> readCsvLineByLine(String file){
        List<String> candidatos = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;

            while((nextRecord = csvReader.readNext())!=null){
                for(String cell : nextRecord){
                    System.out.println(cell + "\t");
                    candidatos.add(cell);
                }
                System.out.println();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return candidatos;
    }

//    public List<Candidato> lerCsv() throws IOException {
//
//        //String path = "c:\\repos\\app-academy\\candidatos.csv";
//        Reader reader = Files.newBufferedReader(Paths.get("c:\\repos\\app-academy\\candidatos.csv"));
//
//        CsvToBean<Candidato> csvToBean = new CsvToBeanBuilder(reader)
//                .withType(Candidato.class)
//                .build();
//
//        List<Candidato> candidatos = csvToBean.parse();
//
//        for(Candidato candidato : candidatos)
//            System.out.println(candidato);
//        return candidatos;
//    }
}

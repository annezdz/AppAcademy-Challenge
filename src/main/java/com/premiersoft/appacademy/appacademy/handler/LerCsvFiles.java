package com.premiersoft.appacademy.appacademy.handler;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
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

}

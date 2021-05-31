package com.premiersoft.appacademy.appacademy.handler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LerCsvFiles {

    public List<String> readCsvLineByLine(String file) throws FileNotFoundException {
        List<String> candidatos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        try{
            String nextRecord;
            br.readLine();
            while((nextRecord = br.readLine())!=null){
               candidatos.add(nextRecord);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return candidatos;
    }

}

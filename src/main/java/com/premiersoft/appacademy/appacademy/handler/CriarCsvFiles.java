package com.premiersoft.appacademy.appacademy.handler;

import com.premiersoft.appacademy.appacademy.model.Candidato;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CriarCsvFiles {


    public void gravarCsv(List<Candidato> candidatos) throws IOException {
        PrintWriter pw = new PrintWriter("Sorted_AppAcademy_Candidates.csv");
        pw.write("nome,vaga,idade,estado \n");
        candidatos.forEach(item -> {
            pw.write(item.toString() + "\n");
        });
        pw.close();

    }
//    public String convertToCsv(String[] data){
//        return Stream.of(data)
//                .map(this::escapeSpecialCharacters)
//                .collect(Collectors.joining(","));
//    }
//
//
//    public String escapeSpecialCharacters(String data){
//        String escapedData = data.replaceAll("\\R"," ");
//        if(data.contains(",") || data.contains("\"") || data.contains("'")){
//            data = data.replace("\"","\"\"");
//            escapedData = "\"" + data + "\"";
//        }
//        return escapedData;
//    }
}

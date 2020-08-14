package com.sysoiev.crudapp;

import com.opencsv.CSVReader;
import com.sysoiev.crudapp.model.Specialty;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DemoCvs {
    private CSVReader reader;

    public Specialty getById(Long id) throws FileNotFoundException {
        reader = new CSVReader(new FileReader("src\\main\\resources\\specialties.csv"), '\t');
        List<String> stringList=new ArrayList<>();

       /* List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : fromFile) {
            if (s.substring(0, s.indexOf(" ")).equals(String.valueOf(id))) {
                return new Specialty(id, s.substring(s.indexOf(' ')));
            }
        }*/

        return null;
    }
    public List<Specialty> getAll() {
        List<Specialty> specialtyList = new ArrayList<>();
       /* List<String> fromFile = null;

        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            for (String s : fromFile) {
                specialtyList.add(new Specialty(Long.parseLong(s.substring(0, s.indexOf(""))), s.substring(s.indexOf(" "))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return specialtyList;
    }
    public static void main(String[] args) throws FileNotFoundException {
        CSVReader reader = new CSVReader(new FileReader("src\\main\\resources\\specialties.csv"), '\t');
        for (Iterator<String[]> it = reader.iterator(); it.hasNext(); ) {
            String[] nextLine = it.next();
            // nextLine[] is an array of values from the line
            System.out.println(Arrays.toString(nextLine));
        }
    }
}

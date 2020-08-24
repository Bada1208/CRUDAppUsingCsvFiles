package com.sysoiev.crudapp.repository.impl;

import com.sysoiev.crudapp.model.Specialty;
import com.sysoiev.crudapp.repository.SpecialtiesRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JavaIOSpecialtyRepositoryImpl implements SpecialtiesRepository {
    private final String filePath = "src\\main\\resources\\specialties.csv";

    @Override
    public Specialty getById(Long id) {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : fromFile) {
            if (s.substring(0, s.indexOf(" ")).equals(String.valueOf(id))) {

                return new Specialty(id, s.substring(s.indexOf(' ')));
            }
        }

        Optional<Specialty> empty = Optional.empty();
        return empty.orElseThrow(NullPointerException::new);
    }

    @Override
    public void deleteById(Long id) {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            fromFile.removeIf(s -> (s.substring(0, s.indexOf(" "))).equals(String.valueOf(id)));
            FileWriter fileWriter = new FileWriter(filePath);
            for (String s : fromFile) {
                fileWriter.write(s + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Specialty update(Specialty item) {
        try {
            List<String> fromFile = Files.readAllLines(Paths.get(filePath));
            for (int i = 0; i < fromFile.size(); i++) {
                String line = fromFile.get(i).substring(0, fromFile.get(i).indexOf(' '));
                if (line.equals(String.valueOf(item.getId()))) {
                    fromFile.set(i, item.toString());
                }
            }
            Files.write(Paths.get(filePath), fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Specialty save(Specialty item) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(item.getId() + " " + item.getSpecialty() + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<Specialty> getAll() {
        List<String> fromFile = null;
        List<Specialty> specialtyList = new ArrayList<>();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {

                if (!line.isEmpty()) {
                    fromFile = Files.readAllLines(Paths.get(filePath));
                    if (fromFile.size() == 0) {
                        return specialtyList;
                    } else {
                        for (String s : fromFile) {
                            specialtyList.add(new Specialty(Long.parseLong(s.substring(0, s.indexOf(" "))), s.substring(s.indexOf(" "))));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return specialtyList;
    }

}
/*File file = new File("Ваш файл");
 BufferedReader br = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "UTF-8"));
String line;
while ((line = br.readLine()) != null) {//тут мы уже проверим,что читаемые строки не равны null
//вот тут можно включить проверку

if (!line.equals("")) {
//смотрит не пустая ли строка,Т.е не равна ли строка line пустоте
}

if (!line.isEmpty()) {
//еще один вариант проверки на непустоту строки
}*/
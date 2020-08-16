package com.sysoiev.crudapp.controller;

import com.sysoiev.crudapp.model.Specialty;
import com.sysoiev.crudapp.repository.SpecialtiesRepository;
import com.sysoiev.crudapp.repository.impl.JavaIOSpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyController {
    private SpecialtiesRepository specialtyRepository = new JavaIOSpecialtyRepositoryImpl();


    public List<Specialty> printAll() {
        return specialtyRepository.getAll();
    }

    public void saveSpecialty(Specialty newSpecialty) {
        specialtyRepository.save(newSpecialty);
    }

    public void deleteSpecialty(long index) {
        specialtyRepository.deleteById(index);
    }

    public void updateSpecialty(Specialty updateSpecialty) {
        specialtyRepository.update(updateSpecialty);

    }

    public Specialty getValueByIndex(long index) {
        return specialtyRepository.getById(index);
    }
}
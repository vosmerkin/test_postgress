package com.example.postgres.service;

import com.example.postgres.entity.Name;
import com.example.postgres.repository.NameCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NameCrudService {
    @Autowired
    private final NameCrudRepo nameCrudRepo;

    public NameCrudService(NameCrudRepo nameCrudRepo) {
        this.nameCrudRepo = nameCrudRepo;
    }

    public void delete(String name){
        List<Name> names = nameCrudRepo.findAllByName(name);
        if (names.size() == 1) {
            nameCrudRepo.delete(names.get(0));
            System.out.println(names.get(0).getName() + " deleted");
        }
    }



}

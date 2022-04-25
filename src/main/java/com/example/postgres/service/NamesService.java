package com.example.postgres.service;

import com.example.postgres.entity.Names;
import com.example.postgres.repository.NameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NamesService {

    @Autowired
    private final NameRepo nameRepo;


    public NamesService(NameRepo nameRepo) {
        this.nameRepo = nameRepo;
    }

    public List<Names> findAllByName(String name) {
        return nameRepo.findAllByName(name);
    }
}

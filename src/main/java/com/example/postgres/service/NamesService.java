package com.example.postgres.service;

import com.example.postgres.entity.Name;
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

    public List<Name> findAllByName(String name) {
        return nameRepo.findAllByName(name);
    }

    public Name save(String name){
        Name nameEntity = new Name();
        nameEntity.setName(name);
//        nameEntity.setId(this.findTopByOrderByIdDesc() + 1);
        nameRepo.save(nameEntity);
        nameRepo.flush();
        System.out.println(nameEntity.getId());
        return nameEntity;
    }

    public int findTopByOrderByIdDesc(){
        List<Name> list = nameRepo.findTopByOrderByIdDesc();
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(0).getId());
        return list.get(0).getId();
    }


}

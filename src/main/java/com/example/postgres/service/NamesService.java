package com.example.postgres.service;

import com.example.postgres.entity.Name;
import com.example.postgres.repository.NameCrudRepo;
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

    public List<Name> findAllByFirstName(String name) {
        return nameRepo.findAllByName(name);
    }

    public Name getById(Integer id) {
        return nameRepo.findById(id).get();
    }

    public Name save(Name nameEntity) {
        nameRepo.save(nameEntity);
//        nameRepo.flush();
        System.out.println(nameEntity.getId());
        return nameEntity;
    }

    public Name updateName(Name nameEntity) {
        Name existingEntity = nameRepo.getById(nameEntity.getId());
        existingEntity.setName(nameEntity.getName());
//        if (existingNameEntity != null) {
//            if (nameEntity.getName() != null) existingNameEntity.setName(nameEntity.getName());
//            if (nameEntity.getCarId() != null) existingNameEntity.setCarId(nameEntity.getCarId());
//        }
        nameRepo.save(existingEntity);
//        nameRepo.flush();
        System.out.println(nameEntity.getId());
        return existingEntity;
    }

    public int findTopByOrderByIdDesc() {
        List<Name> list = nameRepo.findTopByOrderByIdDesc();
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(0).getId());
        return list.get(0).getId();
    }


    public boolean delete(String name) {
        boolean result = false;
        List<Name> names = nameRepo.findAllByName(name);
        if (names.size() == 1) {
            System.out.println(names.get(0).getName() + " deleted");
            nameRepo.delete(names.get(0));
            result = true;
        }
        return result;
    }


}

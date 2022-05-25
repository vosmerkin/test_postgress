package com.example.postgres.repository;

import com.example.postgres.entity.Name;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface NameCrudRepo extends CrudRepository <Name, Long> {
    List<Name> findAllByName(String name);



}

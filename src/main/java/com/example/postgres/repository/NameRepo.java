package com.example.postgres.repository;

import com.example.postgres.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NameRepo extends JpaRepository<Name, Long> {
    List<Name> findAllByName(String name);

//    @Query("SELECT MAX(id) FROM names")
    List<Name> findTopByOrderByIdDesc();
}

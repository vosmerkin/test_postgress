package com.example.postgres.repository;

import com.example.postgres.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameRepo extends JpaRepository<Name, Long> {
    List<Name> findAllByName(String userName);

//    @Query("SELECT MAX(id) FROM names")
    List<Name> findTopByOrderByIdDesc();
}

package com.example.postgres.repository;

import com.example.postgres.entity.Names;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NameRepo extends JpaRepository<Names, Long> {
    List<Names> findAllByName(String name);
}

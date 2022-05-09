package com.example.postgres.repository;

import com.example.postgres.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long> {


}

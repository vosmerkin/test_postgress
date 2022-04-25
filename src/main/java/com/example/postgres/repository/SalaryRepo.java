package com.example.postgres.repository;

import com.example.postgres.entity.Names;
import com.example.postgres.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepo extends JpaRepository<Salary, Long> {


}

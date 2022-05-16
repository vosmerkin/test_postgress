package com.example.postgres.repository;

import com.example.postgres.entity.Car;
import com.example.postgres.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
//    List<Car> findAllByCarMake(String carMake);
//    List<Name> findAllNamesById(Integer id);
//    Integer findIdByCarMake(String carMake);
    Car findCarByCarmake(String carMake);
}

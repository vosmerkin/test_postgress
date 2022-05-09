package com.example.postgres.service;

import com.example.postgres.entity.Car;
import com.example.postgres.entity.Name;
import com.example.postgres.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private final CarRepo carRepo;


    public CarService(CarRepo CarRepo) {
        this.carRepo = CarRepo;
    }

    public List<Name> findCarOwnersByCarMake(String carMake){
    List <Car> cars = carRepo.findAllCarByCarMake(carMake);
        System.out.println(cars);
//        Integer carId = carRepo.findIdByCarMake(carMake);
////
//        return carRepo.findAllNamesById(carId);
        return Collections.emptyList();
    }
}

package com.example.postgres.controllers;

import com.example.postgres.entity.Name;
import com.example.postgres.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/carOwners")
    public List<Name> getCarOwners(@RequestParam(value = "carmake", defaultValue = "*") String carMake) {
        System.out.println(this.getClass() + "___" + carMake);
        return carService.findCarOwnersByCarMake(carMake);
    }
}

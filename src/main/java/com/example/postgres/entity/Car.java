package com.example.postgres.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "carmake")
    private int carMake;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<Name> names;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return carMake;
    }

    public void setSalary(int carMake) {
        this.carMake = carMake;
    }
}

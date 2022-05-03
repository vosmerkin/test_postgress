package com.example.postgres.entity;

import javax.persistence.*;

@Entity
@Table(name = "names")
public class Name {
    public Name(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(name="carid")
    private Integer carId;

    @Column(name="salaryid")
    private Integer salaryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_id")
    private Salary salary;



    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "{\"name\":{" +
                "\"id\":\""+ id +"\""+
                ",\"name\":\""+ name +"\""+
                ",\"carId\":\""+ carId +"\""+
                ",\"salaryId\":\""+ salaryId +"\""+
                "}}";
    }
}

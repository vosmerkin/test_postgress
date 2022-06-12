package com.example.postgres.entity;

import com.example.postgres.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "names")
public class Name {
    public Name(String name) {
        this.name = name;
    }

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Name() {
    }

    //    @Min(value = 1, message = "Id can't be less than 1 or bigger than 999999")
//    @Max(999999)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Column(name="name")
    private String name;

    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "salary_id")
    private Integer salaryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", insertable = false, updatable = false)
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salary_id", insertable = false, updatable = false)
    private Salary salary;

    public Name(Integer id, String name, Integer carId, Integer salaryId) {
        this.id = id;
        this.name = name;
        this.carId = carId;
        this.salaryId = salaryId;
    }

    @Override
    public String toString() {
        String carMake = null;
        Integer salaryAmt = null;
        if (car != null) carMake = car.getCarmake();
        if (salary != null) salaryAmt = salary.getSalary();

        return "Name{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car=" + carMake +
                ", salary=" + salaryAmt +
                '}';
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

    public String toJson() {

        var ow = new ObjectMapper();

//                .writer().withRootName(this.getClass().getSimpleName()).withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            json = "{}";
            e.printStackTrace();
        }
        return json;
    }

    public NameDto toDto() {
        return new NameDto(id,name,carId,salaryId);
    }

}

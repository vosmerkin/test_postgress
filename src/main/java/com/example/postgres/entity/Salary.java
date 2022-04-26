package com.example.postgres.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int salary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "salary")
    private List<Name> names;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

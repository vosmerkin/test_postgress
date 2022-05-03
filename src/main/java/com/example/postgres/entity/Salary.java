package com.example.postgres.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer salary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "salary")
    private List<Name> names;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

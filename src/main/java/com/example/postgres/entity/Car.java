package com.example.postgres.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "carmake")
    private String carmake;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<Name> names;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarmake() {
        return carmake;
    }

    public void setCarmake(String carmake) {
        this.carmake = carmake;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carMake='" + carmake + '\'' +
                ", names=" + names +
                '}';
    }
}

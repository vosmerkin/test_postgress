package com.example.postgres.dto;

import com.example.postgres.entity.Name;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class NameDto {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public NameDto(@Null(groups = {New.class}) @NotNull(groups = {UpdateName.class}) Integer id,
                   @NotNull(groups = {New.class, UpdateName.class}) String name,
                   @Null(groups = {New.class, UpdateName.class}) Integer carId,
                   @Null(groups = {New.class, UpdateName.class}) Integer salaryId) {
        this.id = id;
        this.name = name;
        this.carId = carId;
        this.salaryId = salaryId;
    }

    public interface New {
    }

    public interface UpdateName  {
    }

    @Null(groups = {New.class})
    @NotNull(groups = {UpdateName.class})
    private Integer id;

    @NotNull(groups = {New.class, UpdateName.class})
    private String name;

    @Null(groups = {New.class})
    @Null(groups = {UpdateName.class})
    private Integer carId;

    @Null(groups = {New.class})
    @Null(groups = {UpdateName.class})
    private Integer salaryId;

    public Name toEntity(){
        return new Name(id,name,carId,salaryId);
    }


}

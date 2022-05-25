package com.example.postgres.dto;

import com.example.postgres.entity.Name;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class NameDto {

    public NameDto(@Null(groups = {New.class}) @NotNull(groups = {UpdateName.class}) Integer id,
                   @NotNull(groups = {New.class, UpdateName.class}) String name,
                   @NotNull(groups = {New.class}) @Null(groups = {UpdateName.class}) Integer carId,
                   @NotNull(groups = {New.class}) @Null(groups = {UpdateName.class}) Integer salaryId) {
        this.id = id;
        this.name = name;
        this.carId = carId;
        this.salaryId = salaryId;
    }

    public interface New {
    }

    public interface UpdateName  {
    }

    @Getter @Setter
    @Null(groups = {New.class})
    @NotNull(groups = {UpdateName.class})
    private Integer id;

    @Getter @Setter
    @NotNull(groups = {New.class, UpdateName.class})
    private String name;

    @Getter @Setter
    @Null(groups = {New.class})
    @NotNull(groups = {UpdateName.class})
    private Integer carId;

    @Getter @Setter
    @Null(groups = {New.class})
    @NotNull(groups = {UpdateName.class})
    private Integer salaryId;

    public Name toEntity(){
        return new Name(id,name,carId,salaryId);
    }


}

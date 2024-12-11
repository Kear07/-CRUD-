package com.example.springboot3.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
public class WarehouseDto {

    private int id;

    @Min(0)
    private int stock;

    @NotNull
    private String address;
}

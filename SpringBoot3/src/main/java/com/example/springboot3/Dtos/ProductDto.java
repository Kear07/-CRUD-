package com.example.springboot3.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

    private int id;

    @NotBlank
    private String name;

    @Min(0)
    private double price;

    @NotNull
    private String description;
}

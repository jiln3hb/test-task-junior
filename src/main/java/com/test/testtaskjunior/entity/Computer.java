package com.test.testtaskjunior.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Computer extends Model {
    private String category;
    private String CPUType;

    public Computer(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, String category, String CPUType) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.category = category;
        this.CPUType = CPUType;
    }
}
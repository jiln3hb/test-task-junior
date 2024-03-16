package com.test.testtaskjunior.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "computers")
@JsonTypeName("computer")
public class Computer extends Model {
    private String category;
    private String CPUType;

    public Computer() {
    }

    public Computer(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, String category, String CPUType) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.category = category;
        this.CPUType = CPUType;
    }

    public String getCategory() {
        return category;
    }

    public String getCPUType() {
        return CPUType;
    }
}
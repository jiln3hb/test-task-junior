package com.test.testtaskjunior.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "smartphones")
@JsonTypeName("smartphone")
public class Smartphone extends Model {
    private int memoryAmount;
    private int camerasNumber;

    public Smartphone() {
    }

    public Smartphone(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, int memoryAmount, int camerasNumber) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.memoryAmount = memoryAmount;
        this.camerasNumber = camerasNumber;
    }

    public int getMemoryAmount() {
        return memoryAmount;
    }

    public int getCamerasNumber() {
        return camerasNumber;
    }

}
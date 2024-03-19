package com.test.testtaskjunior.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "smartphones")
@NoArgsConstructor
@Getter
@Setter
public class Smartphone extends Model {
    private int memoryAmount;
    private int camerasNumber;

    public Smartphone(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, int memoryAmount, int camerasNumber) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.memoryAmount = memoryAmount;
        this.camerasNumber = camerasNumber;
    }
}
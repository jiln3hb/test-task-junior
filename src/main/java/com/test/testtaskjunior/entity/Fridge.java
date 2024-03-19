package com.test.testtaskjunior.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fridges")
@NoArgsConstructor
@Getter
@Setter
public class Fridge extends Model {
    private int doorsNumber;
    private String compressorType;

    public Fridge(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, int doorsNumber, String compressorType) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.doorsNumber = doorsNumber;
        this.compressorType = compressorType;
    }
}
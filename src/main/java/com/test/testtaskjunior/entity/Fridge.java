package com.test.testtaskjunior.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fridges")
public class Fridge extends Model {
    private int doorsNumber;
    private String compressorType;

    public Fridge() {
    }

    public Fridge(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, int doorsNumber, String compressorType) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.doorsNumber = doorsNumber;
        this.compressorType = compressorType;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    public String getCompressorType() {
        return compressorType;
    }
}
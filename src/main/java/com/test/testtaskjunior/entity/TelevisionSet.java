package com.test.testtaskjunior.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "television_sets")
public class TelevisionSet extends Model {
    private String category;

    private String technology;

    public TelevisionSet() {
    }

    public TelevisionSet(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, String category, String technology, boolean availability) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.category = category;
        this.technology = technology;
    }

    public String getCategory() {
        return category;
    }

    public String getTechnology() {
        return technology;
    }
}
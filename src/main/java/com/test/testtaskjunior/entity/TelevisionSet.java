package com.test.testtaskjunior.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "television_sets")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TelevisionSet extends Model {
    private String category;
    private String technology;

    public TelevisionSet(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, String category, String technology, boolean availability) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.category = category;
        this.technology = technology;
    }
}
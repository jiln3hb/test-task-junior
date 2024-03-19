package com.test.testtaskjunior.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vacuum_cleaners")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VacuumCleaner extends Model {
    private float volume;
    private int modsNumber;

    public VacuumCleaner(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, float volume, int modsNumber) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.volume = volume;
        this.modsNumber = modsNumber;
    }
}
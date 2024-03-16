package com.test.testtaskjunior.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vacuum_cleaners")
@JsonTypeName("vacuum")
public class VacuumCleaner extends Model {
    private float volume;
    private int modsNumber;

    public VacuumCleaner() {
    }

    public VacuumCleaner(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, float volume, int modsNumber) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.volume = volume;
        this.modsNumber = modsNumber;
    }

    public float getVolume() {
        return volume;
    }

    public int getModsNumber() {
        return modsNumber;
    }
}
package com.test.testtaskjunior.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vacuum_cleaners")
@JsonTypeName("vacuum")
@Schema(description = "Сущность, описывающая модель пылесоса в базе данных")
public class VacuumCleaner extends Model {
    @Schema(description = "Объём пылесборника", example = "0.5", required = true)
    private float volume;
    @Schema(description = "Количество режимов", example = "3", required = true)
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
package com.test.testtaskjunior.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vacuum_cleaners")
@Schema(description = "Сущность, описывающая модель пылесоса в базе данных")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VacuumCleaner extends Model {
    @Schema(description = "Объём пылесборника", example = "0.5", required = true)
    private float volume;
    @Schema(description = "Количество режимов", example = "3", required = true)
    private int modsNumber;

    public VacuumCleaner(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, float volume, int modsNumber) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.volume = volume;
        this.modsNumber = modsNumber;
    }
}
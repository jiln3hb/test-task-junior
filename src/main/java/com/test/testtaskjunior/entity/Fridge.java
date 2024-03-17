package com.test.testtaskjunior.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fridges")
@Schema(description = "Сущность, описывающая модель холодильника в базе данных")
@NoArgsConstructor
@Getter
@Setter
public class Fridge extends Model {
    @Schema(description = "Количество дверей", example = "2", required = true)
    private int doorsNumber;
    @Schema(description = "Тип компрессора", example = "Поршневой", required = true)
    private String compressorType;

    public Fridge(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, int doorsNumber, String compressorType) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.doorsNumber = doorsNumber;
        this.compressorType = compressorType;
    }
}
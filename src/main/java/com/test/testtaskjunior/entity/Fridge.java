package com.test.testtaskjunior.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fridges")
@JsonTypeName("fridge")
@Schema(description = "Сущность, описывающая модель холодильника в базе данных")
public class Fridge extends Model {
    @Schema(description = "Количество дверей", example = "2", required = true)
    private int doorsNumber;
    @Schema(description = "Тип компрессора", example = "Поршневой", required = true)
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
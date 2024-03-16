package com.test.testtaskjunior.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "television_sets")
@JsonTypeName("television")
@Schema(description = "Сущность, описывающая модель телевизора в базе данных")
public class TelevisionSet extends Model {
    @Schema(description = "Категория телевизора", example = "LED", required = true)
    private String category;
    @Schema(description = "Технология изготовления телевизора", example = "QLED", required = true)
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
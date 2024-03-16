package com.test.testtaskjunior.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "computers")
@JsonTypeName("computer")
@Schema(description = "Сущность, описывающая модель компьютера в базе данных")
public class Computer extends Model {
    @Schema(description = "Категория компьютера")
    private String category;
    @Schema(description = "Тип центрального процессора")
    private String CPUType;

    public Computer() {
    }

    public Computer(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, String category, String CPUType) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.category = category;
        this.CPUType = CPUType;
    }

    public String getCategory() {
        return category;
    }

    public String getCPUType() {
        return CPUType;
    }
}
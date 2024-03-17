package com.test.testtaskjunior.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "computers")
@Schema(description = "Сущность, описывающая модель компьютера в базе данных")
@NoArgsConstructor
@Getter
@Setter
public class Computer extends Model {
    @Schema(description = "Категория компьютера", required = true)
    private String category;
    @Schema(description = "Тип центрального процессора", required = true)
    private String CPUType;

    public Computer(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, String category, String CPUType) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.category = category;
        this.CPUType = CPUType;
    }
}
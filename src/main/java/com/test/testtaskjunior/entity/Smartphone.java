package com.test.testtaskjunior.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "smartphones")
@Schema(description = "Сущность, описывающая модель смартфона в базе данных")
@NoArgsConstructor
@Getter
@Setter
public class Smartphone extends Model {
    @Schema(description = "Количество памяти", example = "128", required = true)
    private int memoryAmount;
    @Schema(description = "Число камер", example = "4", required = true)
    private int camerasNumber;

    public Smartphone(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability, int memoryAmount, int camerasNumber) {
        super(productId, name, serialNumber, color, size, price, availability);
        this.memoryAmount = memoryAmount;
        this.camerasNumber = camerasNumber;
    }
}
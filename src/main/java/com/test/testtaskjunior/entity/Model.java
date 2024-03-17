package com.test.testtaskjunior.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
@Schema(description = "Надкласс для всех сущностей моделей, описывающий их общие свойства")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Model {
    @Id
    @SequenceGenerator(name = "model_id_gen", sequenceName = "model_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_id_gen")
    private Long id;
    @Schema(description = "Идентификатор линейки продуктов, на которую ссылается модель", required = true)
    private Long productId;
    @Schema(description = "Наименование модели", example = "name", required = true)
    private String name;
    @Schema(description = "Серийный номер", example = "A1B2C3", required = true)
    private String serialNumber;
    @Schema(description = "Цвет", example = "Black", required = true)
    private String color;
    @Schema(description = "Размер", example = "20x100x50", required = true)
    private String size;
    @Schema(description = "Стоимость", example = "105.54", required = true)
    private BigDecimal price;
    @Schema(description = "Наличие", example = "true", required = true)
    private boolean availability;

    public Model(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability) {
        this.productId = productId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.size = size;
        this.price = price;
        this.availability = availability;
    }
}
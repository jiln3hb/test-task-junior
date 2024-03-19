package com.test.testtaskjunior.dto;

import com.test.testtaskjunior.util.ModelType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Schema(description = "DTO для описания добавляемой модели в addModel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelDTO {
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
    @Schema(description = "Тип модели", example = "TV/VACUUM/FRIDGE/SMARTPHONE/COMPUTER", required = true)
    private ModelType type;
    @Schema(description = "Категория", required = false)
    private String category;
    @Schema(description = "Технология изготовления телевизора", example = "QLED", required = false)
    private String technology;
    @Schema(description = "Объём пылесборника", example = "0.5", required = false)
    private float volume;
    @Schema(description = "Количество режимов", example = "3", required = false)
    private int modsNumber;
    @Schema(description = "Количество дверей", example = "2", required = false)
    private int doorsNumber;
    @Schema(description = "Тип компрессора", example = "Поршневой", required = false)
    private String compressorType;
    @Schema(description = "Количество памяти", example = "128", required = false)
    private int memoryAmount;
    @Schema(description = "Число камер", example = "4", required = false)
    private int camerasNumber;
    @Schema(description = "Тип центрального процессора", example = "ARM", required = false)
    private String CPUType;
}

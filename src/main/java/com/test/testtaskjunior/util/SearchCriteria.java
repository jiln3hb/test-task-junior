package com.test.testtaskjunior.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "Модель для передачи критериев для поиска")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SearchCriteria {
    @Schema(description = "Фильтрация по имени модели", example = "Xiaomi Mi TV A2", required = false)
    private String name;
    @Schema(description = "Тип моделей, по которым производится фильтрация", example = "TV/VACUUM/FRIDGE/SMARTPHONE/COMPUTER", required = false)
    private ModelType type;
    @Schema(description = "Цвет модели", example = "White", required = false)
    private String color;
    @Schema(description = "Стоимость модели", example = "228.13", required = false)
    private BigDecimal price;
    @Schema(description = "Фильтр дешевле/дороже", example = "true", required = false)
    private boolean cheaper;
    @Schema(description = "Категория телевизора/компьютера", example = "LED", required = false)
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

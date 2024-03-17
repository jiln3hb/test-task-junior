package com.test.testtaskjunior.dto;

import com.test.testtaskjunior.util.ModelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ModelDTO {
    private Long productId;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private BigDecimal price;
    private boolean availability;
    private ModelType type;
    private String category;
    private String technology;
    private float volume;
    private int modsNumber;
    private int doorsNumber;
    private String compressorType;
    private int memoryAmount;
    private int camerasNumber;
    private String CPUType;
}

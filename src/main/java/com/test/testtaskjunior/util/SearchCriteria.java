package com.test.testtaskjunior.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SearchCriteria {
    private String name;
    private ModelType type;
    private String color;
    private BigDecimal price;
    private boolean cheaper;
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

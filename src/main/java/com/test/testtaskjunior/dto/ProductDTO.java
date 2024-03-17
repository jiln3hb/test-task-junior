package com.test.testtaskjunior.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDTO {
    private String name;
    private String manufactureCountry;
    private String manufactureCompany;
    private boolean onlineAvailable;
    private boolean instalmentOption;
}

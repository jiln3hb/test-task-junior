package com.test.testtaskjunior.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_gen")
    private Long id;
    private String name;
    private String manufactureCountry;
    private String manufactureCompany;
    private boolean onlineAvailable;
    private boolean instalmentOption;

    public Product(String name, String manufactureCountry, String manufactureCompany, boolean onlineAvailable, boolean instalmentOption) {
        this.name = name;
        this.manufactureCountry = manufactureCountry;
        this.manufactureCompany = manufactureCompany;
        this.onlineAvailable = onlineAvailable;
        this.instalmentOption = instalmentOption;
    }
}
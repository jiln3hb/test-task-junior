package com.test.testtaskjunior.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
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

    @Override
    public String toString() {
        return  "{id= " + id +
                ", name= '" + name + '\'' +
                ", manufactureCountry= '" + manufactureCountry + '\'' +
                ", manufactureCompany= '" + manufactureCompany + '\'' +
                ", onlineAvailable= " + onlineAvailable +
                ", instalmentOption= " + instalmentOption + '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufactureCountry() {
        return manufactureCountry;
    }

    public String getManufactureCompany() {
        return manufactureCompany;
    }

    public boolean isOnlineAvailable() {
        return onlineAvailable;
    }

    public boolean isInstalmentOption() {
        return instalmentOption;
    }
}
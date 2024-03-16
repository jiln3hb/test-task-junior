package com.test.testtaskjunior.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Schema(description = "Сущность, описывающая линейку продуктов")
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_gen")
    private Long id;
    @Schema(description = "Наименование линейки", example = "name", required = true)
    private String name;
    @Schema(description = "Страна производитель", example = "Тайвань", required = true)
    private String manufactureCountry;
    @Schema(description = "Компания производитель", example = "TSMC", required = true)
    private String manufactureCompany;
    @Schema(description = "Определяет доступна ли линейка при заказе онлайн", example = "true", required = true)
    private boolean onlineAvailable;
    @Schema(description = "Определяет доступна ли рассрочка", example = "false", required = true)
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
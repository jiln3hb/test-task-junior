package com.test.testtaskjunior.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Schema(description = "Сущность, описывающая линейку продуктов")
@NoArgsConstructor
@Getter
@Setter
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

    public Product(String name, String manufactureCountry, String manufactureCompany, boolean onlineAvailable, boolean instalmentOption) {
        this.name = name;
        this.manufactureCountry = manufactureCountry;
        this.manufactureCompany = manufactureCompany;
        this.onlineAvailable = onlineAvailable;
        this.instalmentOption = instalmentOption;
    }
}
package com.test.testtaskjunior.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "DTO для описания добавляемого продукта в addProduct")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDTO {
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
}

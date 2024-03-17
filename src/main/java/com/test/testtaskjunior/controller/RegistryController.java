package com.test.testtaskjunior.controller;

import com.test.testtaskjunior.dto.ModelDTO;
import com.test.testtaskjunior.dto.ProductDTO;
import com.test.testtaskjunior.entity.Model;
import com.test.testtaskjunior.entity.Product;
import com.test.testtaskjunior.service.DBService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Registry Controller", description = "Контроллер, обрабатывающий операции с реестром продуктов")
public class RegistryController {
    private final DBService dbService;

    @PostMapping("/api/product")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Добавление линейки продуктов")
    void addProduct(@Parameter(description = "На вход подаются атрибуты, соответствующие сущности линейки продуктов") @RequestBody ProductDTO productDTO) {
        dbService.addProduct(productDTO);
    }

    @PostMapping("/api/model")
    @Operation(summary = "Добавление модели к технике",
            description = "Позволяет добавить модель, которая ссылается на соответствующую линейку техники с помощью атрибута productId")
    @ResponseStatus(HttpStatus.CREATED)
    void addModel(@Parameter(description = "На вход подаются атрибуты, соответствующие данному виду модели") @RequestBody ModelDTO modelDTO) {
        dbService.addModel(modelDTO);
    }
}
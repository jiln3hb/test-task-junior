package com.test.testtaskjunior.controller;

import com.test.testtaskjunior.dto.ModelDTO;
import com.test.testtaskjunior.dto.ProductDTO;
import com.test.testtaskjunior.service.DBService;
import com.test.testtaskjunior.util.SearchCriteria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Registry Controller", description = "Контроллер, обрабатывающий операции с реестром продуктов")
public class RegistryController {
    private final DBService dbService;

    @PostMapping("/api/product")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Добавление линейки продуктов")
    void addProduct(@RequestBody ProductDTO productDTO) {
        log.info("Post mapping /api/product");
        dbService.addProduct(productDTO);
    }

    @PostMapping("/api/model")
    @Operation(summary = "Добавление модели к технике",
            description = "Позволяет добавить модель, которая ссылается на соответствующую линейку техники с помощью атрибута productId")
    @ResponseStatus(HttpStatus.CREATED)
    void addModel(@RequestBody ModelDTO modelDTO) {
        log.info("Post mapping /api/model");
        dbService.addModel(modelDTO);
    }

    @GetMapping("/api/search")
    @Operation(summary = "Поиск по регистру",
            description = "Позволяет осуществить поиск по регистру товаров")
    Object[] searchModels(@RequestBody SearchCriteria searchCriteria) {
        log.info("Get mapping /api/search");
        return dbService.searchModels(searchCriteria).toArray();
    }
}
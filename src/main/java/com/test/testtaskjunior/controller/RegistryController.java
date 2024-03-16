package com.test.testtaskjunior.controller;

import com.test.testtaskjunior.entity.Model;
import com.test.testtaskjunior.entity.Product;
import com.test.testtaskjunior.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistryController {
    private final DBService dbService;

    public RegistryController(DBService dbService) {
        this.dbService = dbService;
    }

    @PostMapping("/api/product")
    @ResponseStatus(HttpStatus.CREATED)
    void addProduct(@RequestBody Product product) {
        dbService.addProduct(product);
    }

    @PostMapping("/api/model")
    @ResponseStatus(HttpStatus.CREATED)
    void addModel(@RequestBody Model model) {
        dbService.addModel(model);
    }
}

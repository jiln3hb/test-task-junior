package com.test.testtaskjunior.controller;

import com.test.testtaskjunior.entity.Model;
import com.test.testtaskjunior.entity.Product;
import com.test.testtaskjunior.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistryController {
    private final DBService dbService;

    @Autowired
    public RegistryController(DBService dbService) {
        this.dbService = dbService;
    }

    @PostMapping("/api/product")
    void addProduct(@RequestBody Product product) {
        dbService.addProduct(product);
    }

    @PostMapping("/api/model")
    void addModel(@RequestBody Model model) {
        dbService.addModel(model);
    }
}

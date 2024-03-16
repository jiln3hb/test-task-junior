package com.test.testtaskjunior.service;

import com.test.testtaskjunior.entity.*;
import com.test.testtaskjunior.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    private final ProductRepo productRepo;
    private final TelevisionSetRepo televisionSetRepo;
    private final VacuumCleanerRepo vacuumCleanerRepo;
    private final FridgeRepo fridgeRepo;
    private final SmartphoneRepo smartphoneRepo;
    private final ComputerRepo computerRepo;

    public DBService(ProductRepo productRepo, TelevisionSetRepo televisionSetRepo, VacuumCleanerRepo vacuumCleanerRepo, FridgeRepo fridgeRepo, SmartphoneRepo smartphoneRepo, ComputerRepo computerRepo) {
        this.productRepo = productRepo;
        this.televisionSetRepo = televisionSetRepo;
        this.vacuumCleanerRepo = vacuumCleanerRepo;
        this.fridgeRepo = fridgeRepo;
        this.smartphoneRepo = smartphoneRepo;
        this.computerRepo = computerRepo;
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void addModel(Model model) {
        if (model instanceof TelevisionSet) {
            televisionSetRepo.save((TelevisionSet) model);
        } else if (model instanceof VacuumCleaner) {
            vacuumCleanerRepo.save((VacuumCleaner) model);
        } else if (model instanceof Fridge) {
            fridgeRepo.save((Fridge) model);
        } else if (model instanceof Smartphone) {
            smartphoneRepo.save((Smartphone) model);
        } else if (model instanceof Computer) {
            computerRepo.save((Computer) model);
        } //TODO make handlers
    }
}

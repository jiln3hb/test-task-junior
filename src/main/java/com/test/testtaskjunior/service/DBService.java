package com.test.testtaskjunior.service;

import com.test.testtaskjunior.entity.*;
import com.test.testtaskjunior.exception.BadRequestException;
import com.test.testtaskjunior.repository.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        for (Field f : product.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.get(product) == null) throw new BadRequestException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        productRepo.save(product);
    }

    public void addModel(Model model) {
        List<Field> fields = Stream.concat(Stream.of(model.getClass().getDeclaredFields()), Stream.of(model.getClass().getSuperclass().getDeclaredFields()))
                .collect(Collectors.toList());
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                if (f.get(model) == null) throw new BadRequestException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

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

    private <T> boolean containsNull(T t) {
        for (Field f : t.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.get(t) == null) return true;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return false;
    }
}
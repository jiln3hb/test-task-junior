package com.test.testtaskjunior.service;

import com.test.testtaskjunior.dto.ModelDTO;
import com.test.testtaskjunior.dto.ProductDTO;
import com.test.testtaskjunior.entity.*;
import com.test.testtaskjunior.exception.BadRequestException;
import com.test.testtaskjunior.exception.NotFoundException;
import com.test.testtaskjunior.mapper.ModelDTOMapper;
import com.test.testtaskjunior.mapper.ProductDTOMapper;
import com.test.testtaskjunior.repository.*;
import com.test.testtaskjunior.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class DBService {
    private final ProductRepo productRepo;
    private final TelevisionSetRepo televisionSetRepo;
    private final VacuumCleanerRepo vacuumCleanerRepo;
    private final FridgeRepo fridgeRepo;
    private final SmartphoneRepo smartphoneRepo;
    private final ComputerRepo computerRepo;
    private final ModelDao modelDao;

    private final ProductDTOMapper productDTOMapper;
    private final ModelDTOMapper modelDTOMapper;

    public void addProduct(ProductDTO productDTO) {
        for (Field f : productDTO.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.get(productDTO) == null) {
                    log.warn("BadRequestException: Product field {} is null", f.getName());
                    throw new BadRequestException();
                }
            } catch (IllegalAccessException e) {
                log.warn("IllegalAccessException: {}", e.getMessage());
            }
        }

        Product product = productDTOMapper.toEntity(productDTO);
        productRepo.save(product);

        log.info("Product with id {} was saved in database", product.getId());
    }

    public void addModel(ModelDTO modelDTO) {
        switch (modelDTO.getType()) {
            case TV:
                TelevisionSet televisionSet = modelDTOMapper.toTV(modelDTO);
                if (productRepo.findById(televisionSet.getProductId()).isPresent()) {
                    if (notContainsAnyNull(televisionSet)) {
                        televisionSetRepo.save(televisionSet);
                        log.info("Television set entity with id {} was saved in database", televisionSet.getId());
                    }
                    else throw new BadRequestException();
                } else{
                    log.warn("NotFoundException: Product with id {} not found in database", televisionSet.getProductId());
                    throw new NotFoundException();
                }
                break;
            case VACUUM:
                VacuumCleaner vacuumCleaner = modelDTOMapper.toVacuum(modelDTO);
                if (productRepo.findById(vacuumCleaner.getProductId()).isPresent()) {
                    if (notContainsAnyNull(vacuumCleaner)) {
                        vacuumCleanerRepo.save(vacuumCleaner);
                        log.info("Vacuum cleaner entity with id {} was saved in database", vacuumCleaner.getId());
                    }
                    else throw new BadRequestException();
                } else{
                    log.warn("NotFoundException: Product with id {} not found in database", vacuumCleaner.getProductId());
                    throw new NotFoundException();
                }
                break;
            case FRIDGE:
                Fridge fridge = modelDTOMapper.toFridge(modelDTO);
                if (productRepo.findById(fridge.getProductId()).isPresent()) {
                    if (notContainsAnyNull(fridge)) {
                        fridgeRepo.save(fridge);
                        log.info("Fridge entity with id {} was saved in database", fridge.getId());
                    }
                    else throw new BadRequestException();
                } else{
                    log.warn("NotFoundException: Product with id {} not found in database", fridge.getProductId());
                    throw new NotFoundException();
                }
                break;
            case SMARTPHONE:
                Smartphone smartphone = modelDTOMapper.toSmartphone(modelDTO);
                if (productRepo.findById(smartphone.getProductId()).isPresent()) {
                    if (notContainsAnyNull(smartphone)) {
                        smartphoneRepo.save(smartphone);
                        log.info("Smartphone entity with id {} was saved in database", smartphone.getId());
                    }
                    else throw new BadRequestException();
                } else{
                    log.warn("NotFoundException: Product with id {} not found in database", smartphone.getProductId());
                    throw new NotFoundException();
                }
                break;
            case COMPUTER:
                Computer computer = modelDTOMapper.toComputer(modelDTO);
                if (productRepo.findById(computer.getProductId()).isPresent()) {
                    if (notContainsAnyNull(computer)) {
                        computerRepo.save(computer);
                        log.info("Computer entity with id {} was saved in database", computer.getId());
                    }
                    else throw new BadRequestException();
                } else{
                    log.warn("NotFoundException: Product with id {} not found in database", computer.getProductId());
                    throw new NotFoundException();
                }
                break;
        }
    }

    public List<Object> searchModels(SearchCriteria searchCriteria) {
        log.info("Searching in database was performed");
        return modelDao.findModelsByCriteria(searchCriteria);
    }

    private <T extends Model> boolean notContainsAnyNull(T t) {
        List<Field> fields = Stream.concat(Stream.of(t.getClass().getDeclaredFields()),
                Stream.of(t.getClass().getSuperclass().getDeclaredFields()).filter(f -> !f.getName().equals("id"))).collect(Collectors.toList());

        for (Field f : fields) {
            f.setAccessible(true);
            try {
                if (f.get(t) == null) {
                    log.warn("BadRequestException: Model field {} is null", f.getName());
                    return false;
                }
            } catch (IllegalAccessException e) {
                log.warn("IllegalAccessException: {}", e.getMessage());
            }
        }

        return true;
    }
}
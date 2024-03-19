package com.test.testtaskjunior.service;

import com.test.testtaskjunior.dto.ModelDTO;
import com.test.testtaskjunior.dto.ProductDTO;
import com.test.testtaskjunior.entity.*;
import com.test.testtaskjunior.exception.BadRequestException;
import com.test.testtaskjunior.mapper.ModelDTOMapper;
import com.test.testtaskjunior.mapper.ProductDTOMapper;
import com.test.testtaskjunior.repository.*;
import com.test.testtaskjunior.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
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
        if (containsAnyNull(productDTO)) throw new BadRequestException();
        productRepo.save(productDTOMapper.toEntity(productDTO));
    }

    public void addModel(ModelDTO modelDTO) {
        switch (modelDTO.getType()) {
            case TV:
                TelevisionSet televisionSet = modelDTOMapper.toTV(modelDTO);
                if (isValid(televisionSet)) televisionSetRepo.save(televisionSet);
                else throw new BadRequestException();
                break;
            case VACUUM:
                VacuumCleaner vacuumCleaner = modelDTOMapper.toVacuum(modelDTO);
                if (isValid(vacuumCleaner)) vacuumCleanerRepo.save(vacuumCleaner);
                else throw new BadRequestException();
                break;
            case FRIDGE:
                Fridge fridge = modelDTOMapper.toFridge(modelDTO);
                if (isValid(fridge)) fridgeRepo.save(fridge);
                else throw new BadRequestException();
                break;
            case SMARTPHONE:
                Smartphone smartphone = modelDTOMapper.toSmartphone(modelDTO);
                if (isValid(smartphone)) smartphoneRepo.save(smartphone);
                else throw new BadRequestException();
                break;
            case COMPUTER:
                Computer computer = modelDTOMapper.toComputer(modelDTO);
                System.out.println(computer.getCPUType());
                if (isValid(computer)) computerRepo.save(computer);
                else throw new BadRequestException();
                break;
        }
    }

    public List<Object> searchModels(SearchCriteria searchCriteria) {
        return modelDao.findModelsByCriteria(searchCriteria);
    }

    private <T extends Model> boolean isValid(T t) {
        boolean validityOfProductId = productRepo.findById(t.getProductId()).isPresent();
        return !containsAnyNull(t) && validityOfProductId;
    }

    private <T> boolean containsAnyNull(T t) {
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

    private <T extends Model> boolean containsAnyNull(T t) {
        List<Field> fields = Stream.concat(Stream.of(t.getClass().getDeclaredFields()),
                Stream.of(t.getClass().getSuperclass().getDeclaredFields()).filter(f -> !f.getName().equals("id"))).collect(Collectors.toList());

        for (Field f : fields) {
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
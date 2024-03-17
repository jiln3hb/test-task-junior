package com.test.testtaskjunior.mapper;

import com.test.testtaskjunior.dto.ModelDTO;
import com.test.testtaskjunior.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModelDTOMapper {
    @Mapping(target = "category", source = "modelDTO.category")
    @Mapping(target = "technology", source = "modelDTO.technology")
    TelevisionSet toTV(ModelDTO modelDTO);
    @Mapping(target = "volume", source = "modelDTO.volume")
    @Mapping(target = "modsNumber", source = "modelDTO.modsNumber")
    VacuumCleaner toVacuum(ModelDTO modelDTO);
    @Mapping(target = "doorsNumber", source = "modelDTO.doorsNumber")
    @Mapping(target = "compressorType", source = "modelDTO.compressorType")
    Fridge toFridge(ModelDTO modelDTO);
    @Mapping(target = "memoryAmount", source = "modelDTO.memoryAmount")
    @Mapping(target = "camerasNumber", source = "modelDTO.camerasNumber")
    Smartphone toSmartphone(ModelDTO modelDTO);
    @Mapping(target = "category", source = "modelDTO.category")
    @Mapping(target = "CPUType", source = "modelDTO.CPUType")
    Computer toComputer(ModelDTO modelDTO);
}

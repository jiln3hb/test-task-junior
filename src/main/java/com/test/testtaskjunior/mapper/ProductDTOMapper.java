package com.test.testtaskjunior.mapper;

import com.test.testtaskjunior.dto.ProductDTO;
import com.test.testtaskjunior.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {
    Product toEntity(ProductDTO productDTO);
}

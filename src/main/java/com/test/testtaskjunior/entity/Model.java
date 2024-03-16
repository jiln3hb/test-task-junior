package com.test.testtaskjunior.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
public class Model {
    @Id
    @SequenceGenerator(name = "model_id_gen", sequenceName = "model_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_id_gen")
    private Long id;
    private Long productId;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private BigDecimal price;
    private boolean availability;

    public Model() {
    }

    public Model(Long productId, String name, String serialNumber, String color, String size, BigDecimal price, boolean availability) {
        this.productId = productId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.size = size;
        this.price = price;
        this.availability = availability;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isAvailability() {
        return availability;
    }

}
package com.test.testtaskjunior.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TelevisionSet.class, name = "television"),
        @JsonSubTypes.Type(value = VacuumCleaner.class, name = "vacuum"),
        @JsonSubTypes.Type(value = Fridge.class, name = "fridge"),
        @JsonSubTypes.Type(value = Smartphone.class, name = "smartphone"),
        @JsonSubTypes.Type(value = Computer.class, name = "computer"),
})
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
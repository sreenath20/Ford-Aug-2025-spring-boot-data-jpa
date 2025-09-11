package com.abc.app.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class ElectronicsProduct {
    @Id
    private Integer id;

    @NotNull(message = "Product name should not be null")
    @Size(min = 5, max = 100, message = "product Name must be min 5 and max 100 char length")
    private String name;
    @Min(value = 1,message = "Product price must be greater than 0.")
    private Double price;
    private Integer stock;
    private LocalDate manufacturingDate;
    private String description;


    public ElectronicsProduct() {
    }

    public ElectronicsProduct(Integer id, String name, Double price, Integer stock, LocalDate manufacturingDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.manufacturingDate = manufacturingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }
}

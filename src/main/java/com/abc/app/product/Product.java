package com.abc.app.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Product {
    @Id
    private Integer id;

    private String name;
    private Double price;
    private Integer stock;
    private LocalDate manufacturingDate;

    public Product() {
    }

    public Product(Integer id, String name, Double price, Integer stock, LocalDate manufacturingDate) {
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

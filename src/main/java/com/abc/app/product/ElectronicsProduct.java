package com.abc.app.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class ElectronicsProduct {
    @Id
    private Integer id;

    @NotBlank(message = "Product name should not be null, Empty, white spaces.")
  //  @Size(min = 5, max = 100, message = "product Name must be min 5 and max 100 char length")
    @Pattern(regexp = "^[a-zA-Z0-9 ]{6,12}$",
            message = "Username must be 6-12 characters long and contain only letters and numbers.")
    private String name;

    @Min(value = 1,message = "Product price must be greater than 0.")
    private Double price;
    // for demo purpose adding email, password
    //@Email(message = "Please enter valid email, e.g : name@domain.com")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "Invalid email format, eg: name@domain.com")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$",
            message = "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;

    private Integer stock;
    @PastOrPresent(message = "Manufacturing date must be in past or current date.")
    private LocalDate manufacturingDate;
    private String description;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

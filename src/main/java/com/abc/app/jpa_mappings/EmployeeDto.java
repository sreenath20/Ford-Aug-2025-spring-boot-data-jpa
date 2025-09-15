package com.abc.app.jpa_mappings;

public class EmployeeDto {
    private String name;
    private Double salary;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

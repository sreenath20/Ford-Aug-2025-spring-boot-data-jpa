package com.abc.app.jpa_mappings;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double salary;


    @OneToOne(cascade = CascadeType.ALL)
    // create fk column in employee table
    @JoinColumn(name = "aaddhar_Id",referencedColumnName = "id")
    @JsonManagedReference
    private Aadhar aadhar;


    public Employee() {
    }

    public Employee(String name, Double salary) {

        this.name = name;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Aadhar getAadhar() {
        return aadhar;
    }

    public void setAadhar(Aadhar aadhar) {
        this.aadhar = aadhar;
    }
}

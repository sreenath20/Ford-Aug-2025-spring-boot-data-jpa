package com.abc.app.jpa_mappings;

import com.abc.app.jpa_mappings.manytoone.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "employees",fetch = FetchType.EAGER)
//    @JsonBackReference
    @JsonIgnore
    private List<Project> projects = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, Double salary) {

        this.name = name;
        this.salary = salary;
    }

    public Employee(Integer id, String name, Double salary, Aadhar aadhar, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.aadhar = aadhar;
        this.projects = projects;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", aadhar=" + aadhar +
                '}';
    }



}

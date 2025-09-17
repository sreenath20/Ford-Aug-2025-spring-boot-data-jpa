package com.abc.app.jpa_mappings.manytoone;

import com.abc.app.jpa_mappings.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double budget;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)//, cascade = CascadeType.ALL)
    @JoinTable(name = "project_emp",
            joinColumns =
            @JoinColumn(name = "prj_id", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "emp_id", referencedColumnName = "ID")
    )
//    @JsonManagedReference
//    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();


    public Project() {
    }

    public Project(Integer id, String name, Double budget, Department department) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.department = department;
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

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", department=" + department +
                '}';
    }
}

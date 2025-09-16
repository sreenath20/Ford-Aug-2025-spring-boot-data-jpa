package com.abc.app.jpa_mappings;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import javax.annotation.processing.Generated;

@Entity
public class Aadhar {
    @Id
    @GeneratedValue
    private Integer id; // name of primary key in aadhar table
    private String aadharNo;

    public Aadhar() {
    }

    // By directional mapping
    // mappedBy will avoid creation of foreigh key to employee
    @OneToOne(mappedBy = "aadhar")
    // there will recursion by Jakson lib
    // to avoid add @JsonIgnore
//    @JsonIgnore
    @JsonBackReference
    private Employee employee;

    public Aadhar(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

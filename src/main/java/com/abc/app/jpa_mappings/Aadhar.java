package com.abc.app.jpa_mappings;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;

@Entity
public class Aadhar {
    @Id
    @GeneratedValue
    private Integer id;
    private String aadharNo;

    public Aadhar() {
    }

    public Aadhar(Integer id, String aadharNo) {
        this.id = id;
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
}

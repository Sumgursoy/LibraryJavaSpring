package com.acunmedya_jvrfs1.Library.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("INSTRUCTOR")
public class Instructer extends User {
    @Column(name="companyName")
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

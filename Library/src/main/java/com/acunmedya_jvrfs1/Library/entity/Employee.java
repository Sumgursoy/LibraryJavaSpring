package com.acunmedya_jvrfs1.Library.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {
    @Column(name="position")
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

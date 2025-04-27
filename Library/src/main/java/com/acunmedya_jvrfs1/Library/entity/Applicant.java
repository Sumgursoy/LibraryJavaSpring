package com.acunmedya_jvrfs1.Library.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("APPLICANT")
public class Applicant extends User {
    @Column(name="about")
    private String about;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}

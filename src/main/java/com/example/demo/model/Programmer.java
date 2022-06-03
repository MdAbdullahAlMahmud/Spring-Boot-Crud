package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    @Column(name = "programmer_name")
    private String  pName;
    private String pLanguage;

    public Programmer() {
    }

    public Programmer(int pId, String pName, String pLanguage) {
        this.pId = pId;
        this.pName = pName;
        this.pLanguage = pLanguage;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpLanguage() {
        return pLanguage;
    }

    public void setpLanguage(String pLanguage) {
        this.pLanguage = pLanguage;
    }
}

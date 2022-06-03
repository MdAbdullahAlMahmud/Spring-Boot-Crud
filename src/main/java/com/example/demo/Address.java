package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Address {

    private String road;
    private String district;

    public Address() {

    }

    public void userAddress(){

        System.out.println("User Address");
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}

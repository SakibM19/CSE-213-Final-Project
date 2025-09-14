package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.commonClass.User;

import java.io.Serializable;

public class Customer extends User implements Serializable {
    private String pickUpLocation, dropOffLocation;

    public Customer(String name, String email, String password, String id, int phoneNumber, String pickUpLocation) {
        super(name, email, password, id, phoneNumber);
        this.pickUpLocation = pickUpLocation;
    }

    public Customer(String name, String email, String password, String id, int phoneNumber, String pickUpLocation, String dropOffLocation) {
        super(name, email, password, id, phoneNumber);
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public Customer(String pickUpLocation, String dropOffLocation) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public Customer(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }


    public Customer() {
    }



    @Override
    public String toString() {
        return "Customer{" +
                "pickUpLocation='" + pickUpLocation + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }
}
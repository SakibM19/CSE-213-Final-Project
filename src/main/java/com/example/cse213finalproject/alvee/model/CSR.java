package com.example.cse213finalproject.alvee.model;

import com.example.cse213finalproject.commonClass.Employee;

import java.io.Serializable;

public class CSR extends Employee implements Serializable {

    public CSR(String name, String email, String password, String id, int phoneNumber, String employeeID, String role) {
        super(name, email, password, id, phoneNumber, employeeID, role);
    }

    public CSR() {
    }

    public CSR(String name, String email, String password, String id, int phoneNumber) {
        super(name, email, password, id, phoneNumber);
    }

    public CSR(String employeeID) {
        super(employeeID);
    }

    @Override
    public String toString() {
        return "CSR{" +
                "employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

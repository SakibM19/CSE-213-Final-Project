package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.commonClass.Employee;

public class FleetManager extends Employee {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public FleetManager(String name, String email, String password, String id, int phoneNumber, String employeeID, String role, String role1) {
        super(name, email, password, id, phoneNumber, employeeID, role);
        this.role = role1;
    }

    public FleetManager(String role) {
        this.role = role;
    }

    public FleetManager(String name, String email, String password, String id, int phoneNumber, String role) {
        super(name, email, password, id, phoneNumber);
        this.role = role;
    }

    public FleetManager(String employeeID, String role) {
        super(employeeID);
        this.role = role;
    }

    @Override
    public String toString() {
        return "FleetManager{" +
                "role='" + role + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public FleetManager(String name, String email, String password, String id, int phoneNumber, String employeeID, String role) {
        super(name, email, password, id, phoneNumber, employeeID, role);
    }

    public FleetManager() {
    }

    public FleetManager(String name, String email, String password, String id, int phoneNumber) {
        super(name, email, password, id, phoneNumber);
    }
}

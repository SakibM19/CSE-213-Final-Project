package com.example.cse213finalproject.commonClass;

import java.io.Serializable;

public abstract class  Employee extends User implements Serializable {
    protected String employeeID;

    public Employee(String name, String email, String password, String id, int phoneNumber, String employeeID, String role) {
        super(name, email, password, id, phoneNumber);
        this.employeeID = employeeID;
    }

    public Employee() {
    }

    public Employee(String name, String email, String password, String id, int phoneNumber) {
        super(name, email, password, id, phoneNumber);
    }

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

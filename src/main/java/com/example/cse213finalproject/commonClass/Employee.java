package com.example.cse213finalproject.commonClass;

public class Employee extends User {
    protected String employeeID, role;

    public Employee(String name, String email, String password, int id, int phoneNumber, String employeeID, String role) {
        super(name, email, password, id, phoneNumber);
        this.employeeID = employeeID;
        this.role = role;
    }

    public Employee(String employeeID, String role) {
        this.employeeID = employeeID;
        this.role = role;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

package com.example.cse213finalproject.alvee.model;

import com.example.cse213finalproject.commonClass.Employee;

import java.io.Serializable;
import java.time.LocalDate;

public class Inspector extends Employee implements Serializable {
    public Inspector(String name, String email, String password, String id, int phoneNumber, String employeeID, String role) {
        super(name, email, password, id, phoneNumber, employeeID, role);
    }

    public Inspector() {
    }

    public Inspector(String name, String email, String password, String id, int phoneNumber) {
        super(name, email, password, id, phoneNumber);
    }

    public Inspector(String employeeID) {
        super(employeeID);
    }

    public Inspection logInspection(String vehicleId, String damages, double fuelLevel, String cleaningStatus, String isAvailable, String extraNote) {
        String insId = "fg";
//        String carId, LocalDate inspectionDate, String damages, boolean isClean, double fuelLevel, boolean isAvailableAfterInspection, String extraNote
        return new Inspection(
                vehicleId,
                LocalDate.now(),
                damages,
                cleaningStatus,
                fuelLevel,
                isAvailable,
                extraNote
        );
    }

    @Override
    public String toString() {
        return "Inspector{" +
                "employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

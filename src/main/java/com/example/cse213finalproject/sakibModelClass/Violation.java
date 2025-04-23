package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.commonClass.SceneSwitch;

public class Violation {
    private String customerID, violationID, vehicleID;
    private int violationCount;

    public Violation(String customerID, String violationID, String vehicleID, int violationCount) {
        this.customerID = customerID;
        this.violationID = violationID;
        this.vehicleID = vehicleID;
        this.violationCount = violationCount;
    }

    public Violation() {
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getViolationID() {
        return violationID;
    }

    public void setViolationID(String violationID) {
        this.violationID = violationID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(int violationCount) {
        this.violationCount = violationCount;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "customerID='" + customerID + '\'' +
                ", violationID='" + violationID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", violationCount=" + violationCount +
                '}';
    }
}

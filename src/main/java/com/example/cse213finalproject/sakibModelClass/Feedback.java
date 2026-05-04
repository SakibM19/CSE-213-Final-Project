package com.example.cse213finalproject.sakibModelClass;

import java.io.Serializable;

public class Feedback implements Serializable {
    private String CustomerID;
    private String vehicleID;
    private int vehicleCondition;
    private int cleanliness;
    private int comfort;
    private String additionalComment;

    public Feedback(String customerID, String vehicleID, int vehicleCondition, int cleanliness, int comfort, String additionalComment) {
        this.CustomerID = customerID;
        this.vehicleID = vehicleID;
        this.vehicleCondition = vehicleCondition;
        this.cleanliness = cleanliness;
        this.comfort = comfort;
        this.additionalComment = additionalComment;
    }

    public Feedback() {}

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(int vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getComfort() {
        return comfort;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "CustomerID='" + CustomerID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", vehicleCondition=" + vehicleCondition +
                ", cleanliness=" + cleanliness +
                ", comfort=" + comfort +
                ", additionalComment='" + additionalComment + '\'' +
                '}';
    }
}

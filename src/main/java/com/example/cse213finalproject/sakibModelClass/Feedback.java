package com.example.cse213finalproject.sakibModelClass;

public class Feedback {

    private String CustomerID, vehicleID;
    private int vehicleCondition;
    private int cleanliness;
    private int comfort;

    public Feedback(String customerID, String vehicleID, int vehicleCondition, int cleanliness, int comfort) {
        CustomerID = customerID;
        this.vehicleID = vehicleID;
        this.vehicleCondition = vehicleCondition;
        this.cleanliness = cleanliness;
        this.comfort = comfort;
    }

    public Feedback() {
    }


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

    @Override
    public String toString() {
        return "Feedback{" +
                "CustomerID='" + CustomerID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", vehicleCondition=" + vehicleCondition +
                ", cleanliness=" + cleanliness +
                ", comfort=" + comfort +
                '}';
    }
}
package com.example.cse213finalproject.sakibModelClass;

import java.io.Serializable;

public class Vehicle implements Serializable {
    protected String vehicleID, vehicleModel, vehicleType, brand, status;
    protected int seatCapacity;
    protected float perDayCost;


    public Vehicle(String vehicleID, String vehicleModel, String vehicleType, String brand, int seatCapacity, float perDayCost) {
        this.vehicleID = vehicleID;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.status = "Under Inspection";
        this.seatCapacity = seatCapacity;
        this.perDayCost = perDayCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID='" + vehicleID + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", brand='" + brand + '\'' +
                ", status='" + status + '\'' +
                ", seatCapacity=" + seatCapacity +
                ", perDayCost=" + perDayCost +
                '}';
    }

    public Vehicle() {
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public float getPerDayCost() {
        return perDayCost;
    }

    public void setPerDayCost(float perDayCost) {
        this.perDayCost = perDayCost;
    }


}

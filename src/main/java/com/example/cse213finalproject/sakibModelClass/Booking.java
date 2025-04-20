package com.example.cse213finalproject.sakibModelClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Booking implements Serializable {
    protected int  totalCost;
    protected String customerName, customerID, bookingID, vehicleId, vehicleModel;
    protected LocalDate pickupDate, dropOffDate;

    public Booking(int totalCost, String customerName, String customerId, String bookingID, LocalDate pickupDate, LocalDate dropOffDate, String vehicleId, String vehicleModel) {
        this.totalCost = totalCost;
        this.customerName = customerName;;
        this.customerID = customerId;
        this.bookingID = bookingID;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", totalCost=" + totalCost +

                ", pickupDate=" + pickupDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }

    public Booking() {
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerId) {
        this.customerID = customerId;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(LocalDate dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public static String generateBookingID() {
        Random random = new Random();
        int number = 100 + random.nextInt(900); // generates a number between 100 and 999
        return "b" + number;
    }

}

package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.util.BinaryFileHelper;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Booking implements Serializable {
    protected int  totalCost;
    protected String customerName, vehicleName, vehicleID, customerId, bookingID;
    protected LocalDate pickupDate, dropOffDate;

    public Booking(int totalCost, String customerName, String vehicleName, String vehicleID, String customerId, String bookingID, LocalTime pickUpTime, LocalTime dropOffTime, LocalDate pickupDate, LocalDate dropOffDate) {
        this.totalCost = totalCost;
        this.customerName = customerName;
        this.vehicleName = vehicleName;
        this.vehicleID = vehicleID;
        this.customerId = customerId;
        this.bookingID = bookingID;

        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", totalCost=" + totalCost +
                ", vehicleID=" + vehicleID +

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

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    /// //////////



    public static String generateBookingID() {
        Random random = new Random();
        int number = 100 + random.nextInt(900); // generates a number between 100 and 999
        return "b" + number;
    }


}

package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.util.BinaryFileHelper;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Booking implements Serializable {
    protected int  totalCost;
    protected String customerName, vehicleName, vehicleID, customerId, bookingID;
    protected LocalTime pickUpTime, dropOffTime;
    protected LocalDate pickupDate, dropOffDate;

    public Booking(int totalCost, String customerName, String vehicleName, String vehicleID, String customerId, String bookingID, LocalTime pickUpTime, LocalTime dropOffTime, LocalDate pickupDate, LocalDate dropOffDate) {
        this.totalCost = totalCost;
        this.customerName = customerName;
        this.vehicleName = vehicleName;
        this.vehicleID = vehicleID;
        this.customerId = customerId;
        this.bookingID = bookingID;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", totalCost=" + totalCost +
                ", vehicleID=" + vehicleID +
                ", pickUpTime=" + pickUpTime +
                ", dropOffTime=" + dropOffTime +
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

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public LocalTime getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(LocalTime dropOffTime) {
        this.dropOffTime = dropOffTime;
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


}

package com.example.cse213finalproject.sakibModelClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Booking implements Serializable {
    protected int bookingID, totalCost, vehicleID, customerId;
    protected String customerName, vehicleName;
    protected LocalTime pickUpTime, dropOffTime;

    public Booking(int bookingID, int totalCost, int vehicleID, int customerId, String customerName, String vehicleName, LocalTime pickUpTime, LocalTime dropOffTime, LocalDate pickupDate, LocalDate dropOffDate) {
        this.bookingID = bookingID;
        this.totalCost = totalCost;
        this.vehicleID = vehicleID;
        this.customerId = customerId;
        this.customerName = customerName;
        this.vehicleName = vehicleName;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
    }

    protected LocalDate pickupDate, dropOffDate;


    public Booking(int bookingID, int totalCost, int vehicleID, LocalTime pickUpTime, LocalTime dropOffTime, LocalDate pickupDate, LocalDate dropOffDate) {
        this.bookingID = bookingID;
        this.totalCost = totalCost;
        this.vehicleID = vehicleID;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
    }

    public Booking(int bookingID, int totalCost, int vehicleID, int customerId, String customerName, LocalTime pickUpTime, LocalTime dropOffTime, LocalDate pickupDate, LocalDate dropOffDate) {
        this.bookingID = bookingID;
        this.totalCost = totalCost;
        this.vehicleID = vehicleID;
        this.customerId = customerId;
        this.customerName = customerName;
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

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
}

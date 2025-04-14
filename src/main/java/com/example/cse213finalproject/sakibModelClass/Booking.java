package com.example.cse213finalproject.sakibModelClass;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    protected int bookingID, totalCost, vehicleID;
    protected LocalTime pickUpTime, dropOffTime;
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


    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
}

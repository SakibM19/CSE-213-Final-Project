package com.example.cse213finalproject.sakibModelClass;

import java.time.LocalTime;

public class Booking {
    protected int bookingID, totalCost;
    protected LocalTime pickUpTime, dropOffTime;

    public Booking(int bookingID, int totalCost, LocalTime pickUpTime, LocalTime dropOffTime) {
        this.bookingID = bookingID;
        this.totalCost = totalCost;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
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

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", totalCost=" + totalCost +
                ", pickUpTime=" + pickUpTime +
                ", dropOffTime=" + dropOffTime +
                '}';
    }
}

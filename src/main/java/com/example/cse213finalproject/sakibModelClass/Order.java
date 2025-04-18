package com.example.cse213finalproject.sakibModelClass;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    protected int orderID, totalCost, bookingID, vehicleID, customerID;
    protected LocalTime pickUpTime, dropOffTime;
    protected LocalDate pickupDate, dropOffDate;

    public Order(int orderID, int totalCost, int bookingID, int vehicleID, int customerID, LocalTime pickUpTime, LocalTime dropOffTime, LocalDate pickupDate, LocalDate dropOffDate) {
        this.orderID = orderID;
        this.totalCost = totalCost;
        this.bookingID = bookingID;
        this.vehicleID = vehicleID;
        this.customerID = customerID;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
    }

    public Order() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", totalCost=" + totalCost +
                ", bookingID=" + bookingID +
                ", vehicleID=" + vehicleID +
                ", customerID=" + customerID +
                ", pickUpTime=" + pickUpTime +
                ", dropOffTime=" + dropOffTime +
                ", pickupDate=" + pickupDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}

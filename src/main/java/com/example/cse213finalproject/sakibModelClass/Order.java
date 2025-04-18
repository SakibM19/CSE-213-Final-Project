package com.example.cse213finalproject.sakibModelClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Order implements Serializable {
    protected float totalCost;
    protected String customerName, orderID, bookingID, vehicleID, customerID;
    protected LocalDate pickupDate, dropOffDate;

    public Order(String customerName, String orderID, String bookingID, String vehicleID, String customerID, LocalDate pickupDate, LocalDate dropOffDate, float dailyCost) {
        this.customerName = customerName;
        this.orderID = orderID;
        this.bookingID = bookingID;
        this.vehicleID = vehicleID;
        this.customerID = customerID;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        calculateTotalCost(dailyCost);
    }

    public Order() {
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    @Override
    public String toString() {
        return "Order{" +
                "totalCost=" + totalCost +
                ", orderID='" + orderID + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", pickupDate=" + pickupDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }


    public static String generateOrderID() {
        Random random = new Random();
        int number = 100 + random.nextInt(900); // generates 100–999
        return "o" + number;
    }

    public void calculateTotalCost(float dailyRate) {
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(pickupDate, dropOffDate);
        if (daysBetween < 0) {
            this.totalCost = 0;
        }
        this.totalCost = (int) (dailyRate * (daysBetween + 1));
    }
}

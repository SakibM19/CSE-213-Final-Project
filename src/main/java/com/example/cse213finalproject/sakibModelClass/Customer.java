package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.commonClass.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Customer extends User {
    private String pickUpLocation, dropOffLocation;
    private ArrayList<Order> orderList;
    private ArrayList<Booking> bookingList;
    private ArrayList<Vehicle> myVehicle;

    public Customer(String name, String email, String password, int id, int phoneNumber, String pickUpLocation, String dropOffLocation, ArrayList<Order> orderList, ArrayList<Booking> bookingList, ArrayList<Vehicle> myVehicle) {
        super(name, email, password, id, phoneNumber);
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.orderList = orderList;
        this.bookingList = bookingList;
        this.myVehicle = myVehicle;
    }

    public Customer(String pickUpLocation, String dropOffLocation, ArrayList<Order> orderList, ArrayList<Booking> bookingList, ArrayList<Vehicle> myVehicle) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.orderList = orderList;
        this.bookingList = bookingList;
        this.myVehicle = myVehicle;
    }

    public Customer(String name, String email, String password, int id, int phoneNumber) {
        super(name, email, password, id, phoneNumber);
    }

    public Customer() {
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public ArrayList<Vehicle> getMyVehicle() {
        return myVehicle;
    }

    public void setMyVehicle(ArrayList<Vehicle> myVehicle) {
        this.myVehicle = myVehicle;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "pickUpLocation='" + pickUpLocation + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                ", orderList=" + orderList +
                ", bookingList=" + bookingList +
                ", myVehicle=" + myVehicle +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

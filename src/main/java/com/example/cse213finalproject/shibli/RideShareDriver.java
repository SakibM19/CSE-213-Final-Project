package com.example.cse213finalproject.shibli;

public class RideShareDriver {
    private String driverId;
    private String name;
    private int totalRides;
    private double earnedRewards;

    public RideShareDriver(String driverId, String name, int totalRides, double earnedRewards) {
        this.driverId = driverId;
        this.name = name;
        this.totalRides = totalRides;
        this.earnedRewards = earnedRewards;
    }

    public String getDriverId() { return driverId; }
    public String getName() { return name; }
    public int getTotalRides() { return totalRides; }
    public double getEarnedRewards() { return earnedRewards; }
}


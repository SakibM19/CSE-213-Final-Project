package com.example.cse213finalproject.shibli;

public class CorporateBooking {
    private String bookingId;
    private String startDate;
    private String endDate;
    private String vehicleType;

    public CorporateBooking(String bookingId, String startDate, String endDate, String vehicleType) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicleType = vehicleType;
    }

    public String getBookingId() { return bookingId; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getVehicleType() { return vehicleType; }
}

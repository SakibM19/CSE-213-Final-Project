package com.example.cse213finalproject.alvee.model;

public class ReservationRequest extends CustomerIssueRequest{
    private String requestType;
    /*private Booking reservationDetails;*/

    public ReservationRequest(String requestId, String customerName, String customerMessage, String requestType) {
        super(requestId, customerName, customerMessage);
        this.requestType = requestType;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "requestType='" + requestType + '\'' +
                /*", reservationDetails=" + reservationDetails +*/
                ", customerMessage='" + customerMessage + '\'' +
                ", requestId='" + requestId + '\'' +
                ", status=" + status +
                '}';
    }

}

package com.example.cse213finalproject.alvee.model;

public class CustomerRequest {
    protected String requestId;
    /*protected Customer customerDetails;*/
    protected boolean status;

    public CustomerRequest(String requestId, /*Customer customerDetails,*/ boolean status) {
        this.requestId = requestId;
        /*this.customerDetails = customerDetails;*/
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    /*public Customer getCustomerDetails() {
        return customerDetails;
    }*/

    public boolean isStatus() {
        return status;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

//    public void setCustomerDetails(Customer customerDetails) {
//        this.customerDetails = customerDetails;
//    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "requestId='" + requestId + '\'' +
                /*", customerDetails=" + customerDetails +*/
                ", status=" + status +
                '}';
    }
}

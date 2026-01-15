package com.example.cse213finalproject.alvee.model;

import java.io.Serializable;

public class CustomerRequest implements Serializable {
    protected String requestId;
    protected String customerName;
    protected String status;

    public CustomerRequest(String requestId, String customerName) {
        this.requestId = requestId;
        this.customerName = customerName;
        this.status = "Pending";
    }

    public CustomerRequest() {
    }

    public String getRequestId() {
        return requestId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "requestId='" + requestId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

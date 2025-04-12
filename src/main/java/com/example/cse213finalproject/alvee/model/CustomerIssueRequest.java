package com.example.cse213finalproject.alvee.model;

public class CustomerIssueRequest extends CustomerRequest{
    protected String customerMessage;

    public CustomerIssueRequest(String requestId, boolean status, String customerMessage) {
        super(requestId, status);
        this.customerMessage = customerMessage;
    }

    public CustomerIssueRequest(String requestId, boolean status) {
        super(requestId, status);
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }
}

package com.example.cse213finalproject.alvee.model;

public class CustomerIssueRequest extends CustomerRequest{
    protected String customerMessage;

    public CustomerIssueRequest(String requestId, String customerName, String customerMessage) {
        super(requestId, customerName);
        this.customerMessage = customerMessage;
    }

    //    public CustomerIssueRequest(String requestId, boolean status) {
//        super(requestId, status);
//    }


    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    @Override
    public String toString() {
        return "CustomerIssueRequest{" +
                "customerMessage='" + customerMessage + '\'' +
                ", requestId='" + requestId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

package com.example.cse213finalproject.alvee.model;

public class CustomerQuery extends CustomerRequest{
    private String querySub, queryDescription, respond, assignedCSR;

    public CustomerQuery(String requestId, boolean status, String querySub, String queryDescription, String respond, String assignedCSR) {
        super(requestId, status);
        this.querySub = querySub;
        this.queryDescription = queryDescription;
        this.respond = respond;
        this.assignedCSR = assignedCSR;
    }

    public CustomerQuery(String requestId, boolean status) {
        super(requestId, status);
    }

    public String getQuerySub() {
        return querySub;
    }

    public String getQueryDescription() {
        return queryDescription;
    }

    public String getRespond() {
        return respond;
    }

    public String getAssignedCSR() {
        return assignedCSR;
    }

    public void setQuerySub(String querySub) {
        this.querySub = querySub;
    }

    public void setQueryDescription(String queryDescription) {
        this.queryDescription = queryDescription;
    }

    public void setRespond(String respond) {
        this.respond = respond;
    }

    public void setAssignedCSR(String assignedCSR) {
        this.assignedCSR = assignedCSR;
    }

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "querySub='" + querySub + '\'' +
                ", queryDescription='" + queryDescription + '\'' +
                ", respond='" + respond + '\'' +
                ", assignedCSR='" + assignedCSR + '\'' +
                ", requestId='" + requestId + '\'' +
                ", status=" + status +
                '}';
    }
}

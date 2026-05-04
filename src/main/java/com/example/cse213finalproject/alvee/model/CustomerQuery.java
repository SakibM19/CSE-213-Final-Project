package com.example.cse213finalproject.alvee.model;

import java.io.Serializable;

public class CustomerQuery extends CustomerRequest implements Serializable {
    private String querySub, queryDescription, respond;

    public CustomerQuery(String requestId, String customerName, String querySub, String queryDescription) {
        super(requestId, customerName);
        this.querySub = querySub;
        this.queryDescription = queryDescription;
        this.respond = null;
    }

    public CustomerQuery() {
    }

    public String getQuerySub() {
        return querySub;
    }

    public void setQuerySub(String querySub) {
        this.querySub = querySub;
    }

    public String getQueryDescription() {
        return queryDescription;
    }

    public void setQueryDescription(String queryDescription) {
        this.queryDescription = queryDescription;
    }

    public String getRespond() {
        return respond;
    }

    public void setRespond(String respond) {
        this.respond = respond;
    }

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "querySub='" + querySub + '\'' +
                ", queryDescription='" + queryDescription + '\'' +
                ", respond='" + respond + '\'' +
                ", requestId='" + requestId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

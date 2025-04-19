package com.example.cse213finalproject.sakibModelClass;


import java.io.Serializable;

public class EmergencyAssistance  implements Serializable {
    private String assistanceType, location;
    private String customerMessage;

    public EmergencyAssistance(String assistanceType, String location, String customerMessage) {
        this.assistanceType = assistanceType;
        this.location = location;
        this.customerMessage = customerMessage;
    }

    public EmergencyAssistance() {
    }

    public String getAssistanceType() {
        return assistanceType;
    }

    public void setAssistanceType(String assistanceType) {
        this.assistanceType = assistanceType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    @Override
    public String toString() {
        return "EmergencyAssistance{" +
                "assistanceType='" + assistanceType + '\'' +
                ", location='" + location + '\'' +
                ", customerMessage='" + customerMessage + '\'' +
                '}';
    }
}


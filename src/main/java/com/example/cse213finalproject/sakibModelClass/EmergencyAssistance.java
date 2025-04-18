package com.example.cse213finalproject.sakibModelClass;

import java.util.List;

public class EmergencyAssistance {
    public String assistanceType;
    public String customerMessage;
    public List<String> typeOfEmergency;


    public EmergencyAssistance(String assistanceType, String customerMessage, List<String> typeOfEmergency) {
        this.assistanceType = assistanceType;
        this.customerMessage = customerMessage;
        this.typeOfEmergency = typeOfEmergency;
    }

    public EmergencyAssistance() {
    }

    public String getAssistanceType() {
        return assistanceType;
    }

    public void setAssistanceType(String assistanceType) {
        this.assistanceType = assistanceType;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    public List<String> getTypeOfEmergency() {
        return typeOfEmergency;
    }

    public void setTypeOfEmergency(List<String> typeOfEmergency) {
        this.typeOfEmergency = typeOfEmergency;
    }

    @Override
    public String toString() {
        return "EmergencyAssistance{" +
                "assistanceType='" + assistanceType + '\'' +
                ", customerMessage='" + customerMessage + '\'' +
                ", typeOfEmergency=" + typeOfEmergency +
                '}';
    }
}

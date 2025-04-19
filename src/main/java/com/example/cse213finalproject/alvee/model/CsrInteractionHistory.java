package com.example.cse213finalproject.alvee.model;

import java.io.Serializable;
import java.time.LocalDate;

public class CsrInteractionHistory extends History implements Serializable {
    private String csrId;

    public CsrInteractionHistory(String historyId, String type, LocalDate date, String csrId) {
        super(historyId, type, date);
        this.csrId = csrId;
    }

    public CsrInteractionHistory(String csrId) {
        this.csrId = csrId;
    }

    public String getCsrId() {
        return csrId;
    }

    public void setCsrId(String csrId) {
        this.csrId = csrId;
    }

    @Override
    public String toString() {
        return "CsrInteractionHistory{" +
                "csrId='" + csrId + '\'' +
                '}';
    }
}

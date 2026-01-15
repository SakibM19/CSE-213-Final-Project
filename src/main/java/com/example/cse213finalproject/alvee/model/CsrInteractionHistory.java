package com.example.cse213finalproject.alvee.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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


    public static List<CsrInteractionHistory> filterByCsrId(List<CsrInteractionHistory> all, String csrId) {
        return all.stream()
                .filter(h -> h.getCsrId().equals(csrId))
                .collect(Collectors.toList());
    }

    public static List<CsrInteractionHistory> filterByTypeAndCsrId(List<CsrInteractionHistory> all, String type, String csrId) {
        return all.stream()
                .filter(h -> h.getType().equals(type) && h.getCsrId().equals(csrId))
                .collect(Collectors.toList());
    }

    public static List<CsrInteractionHistory> removeByCsrId(List<CsrInteractionHistory> all, String csrId) {
        return all.stream()
                .filter(h -> !h.getCsrId().equals(csrId))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CsrInteractionHistory{" +
                "csrId='" + csrId + '\'' +
                "} " + super.toString();
    }
}

package com.example.cse213finalproject.alvee.model;

import java.io.Serializable;
import java.time.LocalDate;

public class History implements Serializable {
    private String historyId;
    private String type;
    private LocalDate date;

    public History(String historyId, String type, LocalDate date) {
        this.historyId = historyId;
        this.type = type;
        this.date = date;
    }

    public History() {
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId='" + historyId + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}

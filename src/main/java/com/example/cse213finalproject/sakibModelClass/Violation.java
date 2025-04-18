package com.example.cse213finalproject.sakibModelClass;

public class Violation {
    private int violationID;
    private String status, violationDetail;


    public Violation() {
    }

    public Violation(int violationID, String status, String violationDetail) {
        this.violationID = violationID;
        this.status = status;
        this.violationDetail = violationDetail;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "violationID=" + violationID +
                ", status='" + status + '\'' +
                ", violationDetail='" + violationDetail + '\'' +
                '}';
    }

    public int getViolationID() {
        return violationID;
    }

    public void setViolationID(int violationID) {
        this.violationID = violationID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViolationDetail() {
        return violationDetail;
    }

    public void setViolationDetail(String violationDetail) {
        this.violationDetail = violationDetail;
    }
}

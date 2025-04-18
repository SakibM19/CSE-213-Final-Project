package com.example.cse213finalproject.sakibModelClass;

import java.time.LocalDate;

public class Refund {
    private int refundAmount, paidAmount, refundID;
    private String reason, status;
    private LocalDate refundDate;


    public Refund() {
    }

    public Refund(int refundAmount, int paidAmount, int refundID, String reason, String status, LocalDate refundDate) {
        this.refundAmount = refundAmount;
        this.paidAmount = paidAmount;
        this.refundID = refundID;
        this.reason = reason;
        this.status = status;
        this.refundDate = refundDate;
    }

    public int getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.refundAmount = refundAmount;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getRefundID() {
        return refundID;
    }

    public void setRefundID(int refundID) {
        this.refundID = refundID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(LocalDate refundDate) {
        this.refundDate = refundDate;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "refundAmount=" + refundAmount +
                ", paidAmount=" + paidAmount +
                ", refundID=" + refundID +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", refundDate=" + refundDate +
                '}';
    }
}

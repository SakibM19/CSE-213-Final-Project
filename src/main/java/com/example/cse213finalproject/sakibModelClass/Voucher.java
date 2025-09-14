package com.example.cse213finalproject.sakibModelClass;

import java.time.LocalDate;

public class Voucher {
    private String voucherCode, offerName, offerDetail;
    private int offerAmount;
    private float offerPercentage;
    private LocalDate expiryDate;


    public Voucher() {
    }

    public Voucher(String voucherCode, String offerName, String offerDetail, int offerAmount, float offerPercentage, LocalDate expiryDate) {
        this.voucherCode = voucherCode;
        this.offerName = offerName;
        this.offerDetail = offerDetail;
        this.offerAmount = offerAmount;
        this.offerPercentage = offerPercentage;
        this.expiryDate = expiryDate;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferDetail() {
        return offerDetail;
    }

    public void setOfferDetail(String offerDetail) {
        this.offerDetail = offerDetail;
    }

    public int getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(int offerAmount) {
        this.offerAmount = offerAmount;
    }

    public float getOfferPercentage() {
        return offerPercentage;
    }

    public void setOfferPercentage(float offerPercentage) {
        this.offerPercentage = offerPercentage;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "voucherCode='" + voucherCode + '\'' +
                ", offerName='" + offerName + '\'' +
                ", offerDetail='" + offerDetail + '\'' +
                ", offerAmount=" + offerAmount +
                ", offerPercentage=" + offerPercentage +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

package com.example.cse213finalproject.sakibModelClass;

import java.time.LocalDate;

public class CreditCard {
    private int cardNo, cvc;
    private String holderName;
    private LocalDate expiryDate;


    public CreditCard(int cardNo, int cvc, String holderName, LocalDate expiryDate) {
        this.cardNo = cardNo;
        this.cvc = cvc;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    public CreditCard() {
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNo=" + cardNo +
                ", cvc=" + cvc +
                ", holderName='" + holderName + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

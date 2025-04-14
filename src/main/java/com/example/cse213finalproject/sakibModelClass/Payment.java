package com.example.cse213finalproject.sakibModelClass;

public class Payment {
    private int paymentAmount;
    private String paymentType;


    public Payment() {
    }

    public Payment(int paymentAmount, String paymentType) {
        this.paymentAmount = paymentAmount;
        this.paymentType = paymentType;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentAmount=" + paymentAmount +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}

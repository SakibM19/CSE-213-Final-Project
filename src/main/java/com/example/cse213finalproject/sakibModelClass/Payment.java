package com.example.cse213finalproject.sakibModelClass;

public abstract class Payment implements PayManage {
    private int paymentAmount, voucherAmount;
    private String paymentType;


    public Payment() {
    }

    public Payment(int paymentAmount, int refundAmount, String paymentType) {
        this.paymentAmount = paymentAmount;
        this.voucherAmount = refundAmount;
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

    public int getRefundAmount() {
        return voucherAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.voucherAmount = refundAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentAmount=" + paymentAmount +
                ", refundAmount=" + voucherAmount +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }

}

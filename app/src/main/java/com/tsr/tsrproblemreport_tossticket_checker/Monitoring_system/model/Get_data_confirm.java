package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model;

public class Get_data_confirm {
    String PaymentPeriodNumber;
    String PaymentAmount;
    String  Discount;
    String NetAmount;
    String  PaymentComplete;

    public String getPaymentPeriodNumber() {
        return PaymentPeriodNumber;
    }

    public void setPaymentPeriodNumber(String paymentPeriodNumber) {
        PaymentPeriodNumber = paymentPeriodNumber;
    }

    public String getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        PaymentAmount = paymentAmount;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getNetAmount() {
        return NetAmount;
    }

    public void setNetAmount(String netAmount) {
        NetAmount = netAmount;
    }

    public String getPaymentComplete() {
        return PaymentComplete;
    }

    public void setPaymentComplete(String paymentComplete) {
        PaymentComplete = paymentComplete;
    }
}

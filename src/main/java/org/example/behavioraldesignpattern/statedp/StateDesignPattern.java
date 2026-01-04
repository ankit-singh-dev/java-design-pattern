package org.example.behavioraldesignpattern.statedp;

class Payment {

    private IPaymentState paymentState;
    private String status;

    public Payment() {
        // at the start payment will be on Initiated Stated
        this.paymentState = new InitiatedPaymentState(this);
        this.status = "Initiated";
    }

    public IPaymentState getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(IPaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void processPayment(Payment payment){
        this.paymentState.processPayment(payment);
    }
}

public class StateDesignPattern {

    public static void main(String[] args) {
        Payment payment = new Payment();
        // Initiated -> Processing
        payment.processPayment(payment);
        // Processing -> Processed
        payment.processPayment(payment);
        // Processed -> Succeed
        payment.processPayment(payment);
        // succeed
        payment.processPayment(payment);
    }
}

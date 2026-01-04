package org.example.behavioraldesignpattern.statedp;

public class FailureState implements IPaymentState {

    private Payment payment;

    public FailureState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void processPayment(Payment payment) {
        System.out.println("Payment failed");
    }
}
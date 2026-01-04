package org.example.behavioraldesignpattern.statedp;

public class SuccessState implements IPaymentState {

    private Payment payment;

    public SuccessState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void processPayment(Payment payment) {
        System.out.println("Payment succeed");
    }
}

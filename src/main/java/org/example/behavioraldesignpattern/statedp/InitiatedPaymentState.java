package org.example.behavioraldesignpattern.statedp;

public class InitiatedPaymentState implements IPaymentState {

    private Payment payment;

    public InitiatedPaymentState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void processPayment(Payment payment) {
        System.out.println("Payment started");
        payment.setPaymentState(new ProcessingState(payment));
        payment.setStatus("Processing");
    }
}


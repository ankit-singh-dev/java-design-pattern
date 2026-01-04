package org.example.behavioraldesignpattern.statedp;

public class ProcessingState implements IPaymentState {

    private Payment payment;

    public ProcessingState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void processPayment(Payment payment) {
        System.out.println("Payment is at processingState");
        payment.setPaymentState(new ProcessedState(payment));
        payment.setStatus("Processed");
    }
}

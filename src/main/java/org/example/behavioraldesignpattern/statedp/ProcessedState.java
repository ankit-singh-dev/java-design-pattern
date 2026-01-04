package org.example.behavioraldesignpattern.statedp;

public class ProcessedState implements IPaymentState {

    private Payment payment;

    public ProcessedState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void processPayment(Payment payment) {
        System.out.println("Payment is processed");
        try{
            payment.setPaymentState(new SuccessState(payment));
            payment.setStatus("success");
        }catch (Exception e){
            payment.setPaymentState(new FailureState(payment));
            payment.setStatus("Failure");
        }
    }
}
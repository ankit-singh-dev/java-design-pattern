package org.example.compositedp.stateandobserver.states;

import org.example.compositedp.stateandobserver.PaymentDto;
import org.example.compositedp.stateandobserver.enums.Status;

public class ProcessedState implements IPayment {

    private PaymentDto paymentDto;

    public ProcessedState(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    @Override
    public void processPayment(PaymentDto paymentDto) {
        System.out.println("Payment Processed");
        try {
            paymentDto.setCurrentState(new SuccessState(paymentDto));
            paymentDto.setStatus(Status.SUCCESS);
        }catch (Exception e){
            paymentDto.setCurrentState(new FailureState(paymentDto));
            paymentDto.setStatus(Status.FAILURE);
        }
    }

}

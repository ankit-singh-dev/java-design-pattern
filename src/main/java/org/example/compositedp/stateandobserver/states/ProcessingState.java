package org.example.compositedp.stateandobserver.states;

import org.example.compositedp.stateandobserver.PaymentDto;
import org.example.compositedp.stateandobserver.enums.Status;

public class ProcessingState implements IPayment{

    private PaymentDto paymentDto;

    public ProcessingState(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    @Override
    public void processPayment(PaymentDto paymentDto) {
        System.out.println("Payment Processing");
        paymentDto.setCurrentState(new ProcessedState(paymentDto));
        paymentDto.setStatus(Status.PROCESSED);
    }
}


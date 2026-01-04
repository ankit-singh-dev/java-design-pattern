package org.example.compositedp.stateandobserver.states;

import org.example.compositedp.stateandobserver.PaymentDto;
import org.example.compositedp.stateandobserver.enums.Status;

public class InitiatedPaymentState implements IPayment{

    private PaymentDto paymentDto;

    public InitiatedPaymentState(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    @Override
    public void processPayment(PaymentDto paymentDto) {
        System.out.println("Payment Initiated");
        paymentDto.setCurrentState(new ProcessingState(paymentDto));
        paymentDto.setStatus(Status.PROCESSING);
    }
}

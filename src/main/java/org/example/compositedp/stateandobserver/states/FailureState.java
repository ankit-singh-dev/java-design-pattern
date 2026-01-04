package org.example.compositedp.stateandobserver.states;

import org.example.compositedp.stateandobserver.PaymentDto;
import org.example.compositedp.stateandobserver.enums.Status;

public class FailureState implements IPayment {

    private PaymentDto paymentDto;

    public FailureState(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    @Override
    public void processPayment(PaymentDto paymentDto) {
        System.out.println("Payment Failed");
        paymentDto.setStatus(Status.FAILURE);
    }
}

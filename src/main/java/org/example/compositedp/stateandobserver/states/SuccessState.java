package org.example.compositedp.stateandobserver.states;

import org.example.compositedp.stateandobserver.PaymentDto;
import org.example.compositedp.stateandobserver.enums.Status;

public class SuccessState implements IPayment {

    private PaymentDto paymentDto;

    public SuccessState(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    @Override
    public void processPayment(PaymentDto paymentDto) {
        System.out.println("Payment Success");
        paymentDto.setStatus(Status.SUCCESS);
    }
}

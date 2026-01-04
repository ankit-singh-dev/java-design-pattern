package org.example.compositedp.stateandobserver;

public class PaymentService {

    public void processPayment(PaymentDto paymentDto){
        paymentDto.getCurrentState().processPayment(paymentDto);
    }

}

package org.example.compositedp.stateandobserver.states;

import org.example.compositedp.stateandobserver.PaymentDto;

public interface IPayment {

    void processPayment(PaymentDto paymentDto);

}

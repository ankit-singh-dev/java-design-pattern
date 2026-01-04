package org.example.compositedp.stateandobserver.observer;

import org.example.compositedp.stateandobserver.PaymentDto;

public interface IObserver {

    void update(PaymentDto paymentDto);
}

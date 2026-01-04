package org.example.compositedp.stateandobserver.observer;

import org.example.compositedp.stateandobserver.PaymentDto;

public class User implements IObserver{


    public User(){
    }

    @Override
    public void update(PaymentDto paymentDto) {
        System.out.println("Current Status of Payment is = "+paymentDto.getStatus().name() + " at user side");
    }
}

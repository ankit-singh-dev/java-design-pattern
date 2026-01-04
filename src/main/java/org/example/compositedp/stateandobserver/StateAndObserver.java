package org.example.compositedp.stateandobserver;

/*
Let's say we have Payment Class where Status can be Initiated, Processing, Processed, Success, Failure
Now using state pattern i can handle the status but let's just say i wanted to notify
customer and the payment gateway about payment status
 */

import org.example.compositedp.stateandobserver.observer.IObserver;
import org.example.compositedp.stateandobserver.observer.PaymentGateway;
import org.example.compositedp.stateandobserver.observer.User;

public class StateAndObserver {

    public static void main(String[] args) {

        PaymentDto paymentDto = new PaymentDto();
        PaymentService paymentService = new PaymentService();

        IObserver user = new User();
        IObserver paymentGateway = new PaymentGateway();

        paymentDto.attach(user);
        paymentDto.attach(paymentGateway);

        paymentService.processPayment(paymentDto);
        paymentService.processPayment(paymentDto);
        paymentService.processPayment(paymentDto);
        paymentService.processPayment(paymentDto);
    }
}

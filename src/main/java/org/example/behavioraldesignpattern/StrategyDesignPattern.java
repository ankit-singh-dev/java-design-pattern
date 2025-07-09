package org.example.behavioraldesignpattern;

interface PaymentStrategy {
    void makePayment();
}

class CreditCardPayment implements PaymentStrategy{

    private final String creditCardNo;

    public CreditCardPayment(String creditCardNo){
        this.creditCardNo = creditCardNo;
    }

    @Override
    public void makePayment() {
        System.out.println("Making payment through Credit card no "+ creditCardNo);
    }
}

class UpiPayment implements PaymentStrategy{

    private final String upiId;

    public UpiPayment(String upiId){
        this.upiId = upiId;
    }

    @Override
    public void makePayment() {
        System.out.println("Making payment through Upi Id "+ upiId);
    }
}

class Client{

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(){
        this.paymentStrategy.makePayment();
    }
}


public class StrategyDesignPattern {

    public static void main(String[] args) {
        // Making Payment through Credit Card
        Client creditCardPay = new Client();
        creditCardPay.setPaymentStrategy(new CreditCardPayment("1234-5678-1234"));

        creditCardPay.processPayment();

        // Making Payment through Upi
        Client upiPay = new Client();
        upiPay.setPaymentStrategy(new UpiPayment("aaa@ybl.com"));

        upiPay.processPayment();
    }
}

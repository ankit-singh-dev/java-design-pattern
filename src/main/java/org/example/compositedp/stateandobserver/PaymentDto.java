package org.example.compositedp.stateandobserver;

import org.example.compositedp.stateandobserver.enums.Status;
import org.example.compositedp.stateandobserver.observer.IObservable;
import org.example.compositedp.stateandobserver.observer.IObserver;
import org.example.compositedp.stateandobserver.states.IPayment;
import org.example.compositedp.stateandobserver.states.InitiatedPaymentState;

import java.util.ArrayList;
import java.util.List;

public class PaymentDto implements IObservable {

    private List<IObserver> observersList;

    private IPayment currentState;

    private Status status;

    public PaymentDto(){
        this.currentState = new InitiatedPaymentState(this);
        this.status = Status.INITIATED;
        observersList = new ArrayList<>();
    }


    public IPayment getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IPayment currentState) {
        this.currentState = currentState;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.notifyObServer();
    }

    @Override
    public void attach(IObserver iObserver) {
        this.observersList.add(iObserver);
    }

    @Override
    public void detach(IObserver iObserver) {
        this.observersList.remove(iObserver);
    }

    @Override
    public void notifyObServer() {
        for (IObserver observer : observersList){
            observer.update(this);
        }
    }
}

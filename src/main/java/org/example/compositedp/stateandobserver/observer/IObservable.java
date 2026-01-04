package org.example.compositedp.stateandobserver.observer;

public interface IObservable {

    void attach(IObserver iObserver);

    void detach(IObserver iObserver);

    void notifyObServer();
}

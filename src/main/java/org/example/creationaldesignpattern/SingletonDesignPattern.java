package org.example.creationaldesignpattern;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 Singleton design pattern eager implementation
 */
class SingletonEager{

    // Eager initialisation
    private static SingletonEager instance = new SingletonEager();

    // Making constructor as private so outside class can't access it directory
    private SingletonEager(){}

    public static SingletonEager getInstance(){
        return instance;
    }
}

/*
 Singleton design pattern lazy implementation
 */
class SingletonLazy{

    // Lazy initialisation
    private static SingletonLazy instance = null;

    // Making constructor as private so outside class can't access it directory
    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(Objects.isNull(instance)){
            instance = new SingletonLazy();
        }
        return instance;
    }
}

/*
 Break singleton lazy implementation using multithreading
 */
class BreakSingletonLazyImplementation{

    // Lazy initialisation
    private static BreakSingletonLazyImplementation instance = null;

    // Making constructor as private so outside class can't access it directory
    private BreakSingletonLazyImplementation(){}

    public static BreakSingletonLazyImplementation getInstance() throws InterruptedException{
        if(Objects.isNull(instance)){
            // breaking lazy initialisation using thread concept
            Thread.sleep(1000);
            instance = new BreakSingletonLazyImplementation();
        }
        return instance;
    }
}

class SingletonThreadSafe{

    // Lazy initialisation
    private static SingletonThreadSafe instance = null;

    // Making constructor as private so outside class can't access it directory
    private SingletonThreadSafe(){}

    /*
        synchronized method code base but it will block read operation
    public static synchronized SingletonThreadSafe getInstance() throws InterruptedException{
        if(Objects.isNull(instance)){
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
    */

    public static SingletonThreadSafe getInstance() throws InterruptedException{
        if(Objects.isNull(instance)){
            synchronized (SingletonThreadSafe.class) {
                if(Objects.isNull(instance)) {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }

}

public class SingletonDesignPattern {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        isObjectSame(SingletonEager.getInstance(),SingletonEager.getInstance());
        isObjectSame(SingletonLazy.getInstance(),SingletonLazy.getInstance());

        //Code to break singleton design pattern using multithreading
        FutureTask<BreakSingletonLazyImplementation> futureArray[] = new FutureTask[2];
        for(int i=0;i<2;i++){
            Callable<BreakSingletonLazyImplementation> job = () -> BreakSingletonLazyImplementation.getInstance();
            FutureTask<BreakSingletonLazyImplementation> task = new FutureTask<>(job);
            futureArray[i] = task;
        }

        new Thread(futureArray[0]).start();
        new Thread(futureArray[1]).start();

        Thread.sleep(3000);

        if(futureArray[0].isDone() && futureArray[1].isDone()){
            isObjectSame(futureArray[0].get(),futureArray[1].get());
        }

        isObjectSame(SingletonThreadSafe.getInstance(),SingletonThreadSafe.getInstance());
    }

    private static void isObjectSame(Object obj1,Object obj2){
        if(obj1.hashCode() == obj2.hashCode()){
            System.out.println("Only one object has been created");
        }else{
            System.out.println("Error multiple object has been created");
        }
    }
}

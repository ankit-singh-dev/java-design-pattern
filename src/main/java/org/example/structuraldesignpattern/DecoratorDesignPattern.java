package org.example.structuraldesignpattern;

/*
https://www.baeldung.com/java-decorator-pattern
https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
 */
/*
Decorator patterns allow a user to add new functionality to an existing object
without altering its structure.
 */

interface Car{
    void show();
}

class BasicCar implements Car{

    @Override
    public void show() {
        System.out.println("Basic car with basic features");
    }
}

class CarDecorator implements Car{

    Car car;

    public CarDecorator(Car car){
        this.car = car;
    }

    @Override
    public void show() {
        this.car.show();
    }
}

class MountainCar extends CarDecorator{

    public MountainCar(Car car) {
        super(car);
    }

    @Override
    public void show(){
        super.show();
        System.out.println("Adding mountain features");
    }
}

class SUVCar extends CarDecorator{

    public SUVCar(Car car) {
        super(car);
    }

    @Override
    public void show(){
        super.show();
        System.out.println("Adding SUV features");
    }
}

public class DecoratorDesignPattern {
    public static void main(String[] args) {

        // Basic car with mountain car features
        Car mountainCar = new MountainCar(new BasicCar());
        mountainCar.show();

        // Basic car with SUV car features
        Car suvCar = new SUVCar(new BasicCar());
        suvCar.show();

        // Basic car with SUV and mountain car features
        Car suvCarWithMountainFeatures = new SUVCar(new MountainCar(new BasicCar()));
        suvCarWithMountainFeatures.show();

    }
}

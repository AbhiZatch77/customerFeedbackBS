package org.example;

public class AbstractFactoryPattern {

    public static void main(String[] args) {
        vehicleFactory factory = FactoryProducer.getFactory("luxury");
        Car car = factory.createCar();
        Bike bike = factory.createBike();
        car.drive();
        bike.ride();
    }
}

package org.example;

public class luxuryVehicleFactory implements vehicleFactory{
    @Override
    public Car createCar() {
        return new Sedan();
    }

    @Override
    public Bike createBike() {
        return new SportsBike();
    }
}

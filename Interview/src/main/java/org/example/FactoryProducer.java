package org.example;

public class FactoryProducer {

    public static vehicleFactory getFactory(String type) {
        if(type.equalsIgnoreCase("luxury"))
            return new luxuryVehicleFactory();
        else if (type.equalsIgnoreCase("offRoad")) {
            //return new OffROadVehicelFactory()
        }
        return null;
    }

}

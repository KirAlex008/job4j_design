package ru.job4j.parking;

public class Car extends AbstrVehicle{

    public Car(int vehicleSize, int idOfVehicle) {
        super(vehicleSize, idOfVehicle);
    }

    @Override
    public int getVehicleSize() {
        return super.getVehicleSize();
    }

    @Override
    public int getIdOfVehicle() {
        return super.getIdOfVehicle();
    }
}

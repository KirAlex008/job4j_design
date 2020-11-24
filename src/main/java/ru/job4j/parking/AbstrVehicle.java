package ru.job4j.parking;

public abstract class AbstrVehicle implements Vehicle {

    int vehicleSize;

    public AbstrVehicle(int vehicleSize) {
        this.vehicleSize = vehicleSize;
    }
    public int getVehicleSize() {
        return vehicleSize;
    }
}

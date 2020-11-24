package ru.job4j.parking;

public abstract class AbstrVehicle implements Vehicle {

    int vehicleSize;
    int idOfVehicle;

    public AbstrVehicle(int vehicleSize, int idOfVehicle) {
        this.vehicleSize = vehicleSize;
        this.idOfVehicle = idOfVehicle;
    }

    public int getVehicleSize() {
        return vehicleSize;
    }

    public int getIdOfVehicle() {
        return idOfVehicle;
    }
}

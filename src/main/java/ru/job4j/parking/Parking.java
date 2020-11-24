package ru.job4j.parking;

public interface Parking {
    abstract int getFreePlaceOfTracks();
    abstract int getFreePlaceOfCars();
    abstract void replaceVehicle(Vehicle vehicle);

}

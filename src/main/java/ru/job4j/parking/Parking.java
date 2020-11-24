package ru.job4j.parking;

public interface Parking {
    public abstract int getFreePlaceOfTracks();
    public abstract int getFreePlaceOfCars();
    public abstract void replaceVehicle(Vehicle vehicle);
}

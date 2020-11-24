package ru.job4j.parking;

public abstract class ParkPlace {
    int numberOfCar;
    boolean occupancy;

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public boolean isOccupancy() {
        return occupancy;
    }

    public void setOccupancy(boolean occupancy) {
        this.occupancy = occupancy;
    }
}

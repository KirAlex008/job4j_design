package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstrParking implements Parking {

    private int amountOfCars;
    private int amountOfTracks;
    private int counterCarCells = 0;
    private int counterTruckCells = 0;
    private List<Vehicle> listOfCars  = new ArrayList<>();
    private List<Vehicle> listOfTracks  = new ArrayList<>();

    //private ParkPlace [] parkPlacesForCars = new ParkPlace[amountOfCars];
    //private ParkPlace [] parkPlacesForTrucks = new ParkPlace[amountOfTracks];

    public AbstrParking(int amountOfCars, int amountOfTracks) {
        this.amountOfCars = amountOfCars;
        this.amountOfTracks = amountOfTracks;
    }

    public abstract int getFreePlaceOfTracks();
    public abstract int getFreePlaceOfCars();
    public abstract void replaceVehicle(Vehicle vehicle);


    public List<Vehicle> getListOfCars() {
        return listOfCars;
    }

    public List<Vehicle> getListOfTracks() {
        return listOfTracks;
    }

    public int getAmountOfCars() {
        return amountOfCars;
    }

    public int getAmountOfTracks() {
        return amountOfTracks;
    }

    public int getCounterCarCells() {
        return counterCarCells;
    }

    public void setCounterCarCells(int counterCarCells) {
        this.counterCarCells = counterCarCells;
    }

    public int getCounterTruckCells() {
        return counterTruckCells;
    }

    public void setCounterTruckCells(int counterTruckCells) {
        this.counterTruckCells = counterTruckCells;
    }
}

package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstrParking implements Parking {

    private int amountOfCars;
    private int amountOfTracks;
    //private List<AbstrVehicle> listOfCars  = new ArrayList<>();
    //private List<AbstrVehicle> listOfTracks  = new ArrayList<>();

    private ParkPlace [] parkPlacesForCars = new ParkPlace[amountOfCars];
    private ParkPlace [] parkPlacesForTrucks = new ParkPlace[amountOfTracks];

    public AbstrParking(int amountOfCars, int amountOfTracks) {
        this.amountOfCars = amountOfCars;
        this.amountOfTracks = amountOfTracks;
    }

    public abstract int getFreePlaceOfTracks();
    public abstract int getFreePlaceOfCars();
    public abstract void replaceVehicle(Vehicle vehicle);

    public ParkPlace[] getParkPlacesForCars() {
        return parkPlacesForCars;
    }

    public ParkPlace[] getParkPlacesForTrucks() {
        return parkPlacesForTrucks;
    }
}

package ru.job4j.parking;

public class SupermarketParcking extends AbstrParking {
    public SupermarketParcking(int amountOfCars, int amountOfTracks) {
        super(amountOfCars, amountOfTracks);
    }

    @Override
    public int getFreePlaceOfTracks() {
        return 0;
    }

    @Override
    public int getFreePlaceOfCars() {
        return 0;
    }

    @Override
    public void replaceTrack() {

    }

    @Override
    public void replaceCar() {

    }
}

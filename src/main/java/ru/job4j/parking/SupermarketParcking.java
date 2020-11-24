package ru.job4j.parking;

public class SupermarketParcking extends AbstrParking {
    public SupermarketParcking(int amountOfCars, int amountOfTracks) {
        super(amountOfCars, amountOfTracks);
    }

    @Override
    public int getFreePlaceOfTracks() {
        int occupancyPlaces = 0;
        for (var el : this.getParkPlacesForTrucks()) {
            if (el.occupancy == true) {
                occupancyPlaces++;
            }
        }
        return this.getParkPlacesForTrucks().length - occupancyPlaces;
    }

    @Override
    public int getFreePlaceOfCars() {
        int occupancyPlaces = 0;
        for (var el : this.getParkPlacesForCars()) {
            if (el.occupancy == true) {
                occupancyPlaces++;
            }
        }
        return this.getParkPlacesForCars().length - occupancyPlaces;
    }

    @Override
    public void replaceVehicle(Vehicle vehicle) {

    }

    @Override
    public ParkPlace[] getParkPlacesForCars() {
        return super.getParkPlacesForCars();
    }

    @Override
    public ParkPlace[] getParkPlacesForTrucks() {
        return super.getParkPlacesForTrucks();
    }

}

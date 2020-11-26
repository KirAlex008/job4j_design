package ru.job4j.parking;

public class SupermarketParcking extends AbstrParking {
    public SupermarketParcking(int amountOfCars, int amountOfTracks) {
        super(amountOfCars, amountOfTracks);
    }

    @Override
    public int getFreePlaceOfTracks() {
        return this.getAmountOfTracks() - this.getListOfTracks().size();
    }

    @Override
    public int getFreePlaceOfCars() {
        return this.getAmountOfCars() - this.getListOfCars().size();
    }

    @Override
    public void replaceVehicle(Vehicle vehicle) {
        boolean flag = false;
        int times = vehicle.getVehicleSize();
        if (times == 1 && this.getCounterCarCells() < this.getAmountOfCars() - 1) {
            //int index = this.getCounterCarCells() + 1;
            this.setCounterCarCells(this.getCounterCarCells() + 1);
            this.getListOfCars().add(vehicle);
            //System.out.println("1");
        }

        if (times > 1 && this.getCounterTruckCells() <= this.getAmountOfTracks() - 1) {
            this.setCounterTruckCells(this.getCounterTruckCells() + 1);
            this.getListOfTracks().add(vehicle);
            flag = true;
            //System.out.println("3");
        }
        if (!flag && times > 1 && this.getCounterTruckCells() > this.getAmountOfTracks() - 1) {
            for (int i = 1; i <= times; i++) {
                this.setCounterCarCells(this.getCounterCarCells() + 1);
                this.getListOfCars().add(vehicle);
                //System.out.println("2");
            }
        }

    }
}
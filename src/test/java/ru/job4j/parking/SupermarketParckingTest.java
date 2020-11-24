package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SupermarketParckingTest {
    @Test
    public void whenCarAndTruckRepolaced() {
        Vehicle car1 = new Car(1,1);
        Vehicle truck1 = new Truck(2,1);
        Vehicle truck2 = new Truck(2,2);
        Vehicle truck3 = new Truck(2,3);
        Parking parcking = new SupermarketParcking(10,1);
        parcking.replaceVehicle(car1);
        parcking.replaceVehicle(truck1);
        parcking.replaceVehicle(truck2);
        parcking.replaceVehicle(truck3);
        int expect = 5;
        int result = parcking.getFreePlaceOfCars();
        assertThat(result, is(expect));
    }
}
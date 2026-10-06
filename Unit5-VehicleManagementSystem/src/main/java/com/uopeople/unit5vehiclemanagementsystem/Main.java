package com.uopeople.unit5vehiclemanagementsystem;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Q2: Create an ArrayList of Vehicle objects
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Toyota", "Corolla", 2022));
        vehicles.add(new Motorbike("Honda", "CBR500R", 2023));
        vehicles.add(new Car("Subaru", "Forester", 2021));
        vehicles.add(new Motorbike("Yamaha", "MT-07", 2024));

        //Q2: Illustrate polymorphism
        System.out.println("+++__ VEHICLE DETAILS __+++");

        for (Vehicle vehicle : vehicles) {
            vehicle.showDetails();
        }

        //Q3: Show interface upcasting
        System.out.println();
        System.out.println("+++__ MAINTENANCE VEHICLE DETAILS __+++");

        Serviceable carService = new Car("Toyota", "Corolla", 2022);
        Serviceable motorbikeService = new Motorbike("Honda", "CBR500R", 2023);

        carService.scheduleService();
        carService.completeService();

        motorbikeService.scheduleService();
        motorbikeService.completeService();

    }
}


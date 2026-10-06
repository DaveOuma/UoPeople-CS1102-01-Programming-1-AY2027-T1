package com.uopeople.unit5vehiclemanagementsystem;

public class Motorbike extends Vehicle implements Serviceable {

    public Motorbike(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public void showDetails() {
        System.out.println(
                "Motorbike: " + brand + " " + model + " (" + year + ")"
        );
    }

    @Override
    public void scheduleService() {
        System.out.println(
                "Service scheduled for Motorbike: " + brand + " " + model
        );
    }

    @Override
    public void completeService() {
        System.out.println(
                "Service completed for Motorbike: " + brand + " " + model
        );
    }
}

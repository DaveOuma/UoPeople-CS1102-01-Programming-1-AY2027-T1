package com.uopeople.unit5vehiclemanagementsystem;

public class Car extends Vehicle implements Serviceable{

    public Car(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public void showDetails() {
        System.out.println(
                "Car: " + brand + " " + model + " (" + year + ")"
        );
    }

    @Override
    public void scheduleService(){
        System.out.println(
                "Service scheduled for Car: " + brand + " " + model
        );
    }

    @Override
    public void completeService(){
        System.out.println(
                "Service completed for Car: " + brand + " " + model
        );
    }
}

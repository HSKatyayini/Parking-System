/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Car extends Vehicle {
    private static final double RATE_PER_HOUR = 30.0;

    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateCharge(long hours) {
        return RATE_PER_HOUR * hours;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car ID: " + getVehicleId() + ", Number: " + getVehicleNumber() +
                ", Owner: " + getOwnerName() + ", Entry: " + getFormattedEntryTime());
    }
}

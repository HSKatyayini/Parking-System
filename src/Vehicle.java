/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Vehicle implements Serializable {
    private static int idCounter = 100;  // for unique vehicle IDs
    private String vehicleId;
    private String vehicleNumber;
    private String ownerName;
    private LocalDateTime entryTime;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.entryTime = LocalDateTime.now();
        this.vehicleId = "V" + (idCounter++);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public String getFormattedEntryTime() {
        return entryTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public abstract double calculateCharge(long hours);

    public abstract void displayInfo();
}


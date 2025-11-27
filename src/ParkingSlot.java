/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;

public class ParkingSlot implements Serializable {
    private Vehicle vehicle;

    public boolean isEmpty() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle v) {
        this.vehicle = v;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void removeVehicle() {
        vehicle = null;
    }
}


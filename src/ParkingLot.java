/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements Serializable {
    private List<ParkingSlot> slots;
    private static final String FILE_NAME = "parkingData.txt";

    public ParkingLot(int size) {
        slots = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            slots.add(new ParkingSlot());
        }
        loadData();
    }

    public void addVehicle(Vehicle v) {
        for (ParkingSlot slot : slots) {
            if (slot.isEmpty()) {
                slot.parkVehicle(v);
                System.out.println("Vehicle parked successfully! ID: " + v.getVehicleId());
                saveData();
                return;
            }
        }
        System.out.println(" No empty slot available!");
    }

    public void removeVehicle(String id) {
        for (ParkingSlot slot : slots) {
            if (!slot.isEmpty() && slot.getVehicle().getVehicleId().equals(id)) {
                Vehicle v = slot.getVehicle();
                long hours = Math.max(1, Duration.between(v.getEntryTime(), LocalDateTime.now()).toHours());
                double charge = v.calculateCharge(hours);
                slot.removeVehicle();
                saveData();
                System.out.println("Vehicle removed. Charge: ₹" + charge);
                return;
            }
        }
        System.out.println(" Vehicle ID not found!");
    }

    public void searchVehicle(String number) {
        for (ParkingSlot slot : slots) {
            if (!slot.isEmpty() && slot.getVehicle().getVehicleNumber().equalsIgnoreCase(number)) {
                System.out.println("Vehicle found:");
                slot.getVehicle().displayInfo();
                return;
            }
        }
        System.out.println(" Vehicle not found!");
    }

    public void displayAll() {
        for (ParkingSlot slot : slots) {
            if (!slot.isEmpty()) {
                slot.getVehicle().displayInfo();
            }
        }
    }

    
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(slots);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            slots = (List<ParkingSlot>) ois.readObject();
        } catch (Exception e) {
           
        }
    }
}


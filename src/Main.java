/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot lot = new ParkingLot(5);

        while (true) {
            try {
                System.out.println("\n--- VEHICLE PARKING SYSTEM ---");
                System.out.println("1. Park Vehicle");
                System.out.println("2. Remove Vehicle");
                System.out.println("3. Search Vehicle");
                System.out.println("4. Display All");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        System.out.print("Enter Vehicle Type (car/bike): ");
                        String type = sc.nextLine().toLowerCase();
                        System.out.print("Enter Vehicle Number: ");
                        String number = sc.nextLine();
                        System.out.print("Enter Owner Name: ");
                        String owner = sc.nextLine();

                        Vehicle v = null;
                        if (type.equals("car"))
                            v = new Car(number, owner);
                        else if (type.equals("bike"))
                            v = new Bike(number, owner);
                        else {
                            System.out.println("Invalid vehicle type!");
                            break;
                        }
                        lot.addVehicle(v);
                        break;

                    case 2:
                        System.out.print("Enter Vehicle ID to remove: ");
                        String id = sc.nextLine();
                        lot.removeVehicle(id);
                        break;

                    case 3:
                        System.out.print("Enter Vehicle Number to search: ");
                        String num = sc.nextLine();
                        lot.searchVehicle(num);
                        break;

                    case 4:
                        lot.displayAll();
                        break;

                    case 5:
                        System.out.println("Thank you! Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println(" Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Please enter a valid number!");
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("️ Error: " + e.getMessage());
            }
        }
    }
}

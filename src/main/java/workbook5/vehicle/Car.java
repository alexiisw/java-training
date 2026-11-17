package workbook5.vehicle;

public class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String color,
               int numberOfPassengers,
               int cargoCapacity,
               int fuelCapacity,
               int numberOfDoors) {

        super("Car: ", color, numberOfPassengers, cargoCapacity, fuelCapacity);

        this.numberOfDoors = numberOfDoors;
    }
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    public void honkHorn () {
        System.out.println("Beep Beep!");
    }
}

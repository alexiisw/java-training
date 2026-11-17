package workbook5.vehicle;

public class SemiTruck extends Vehicle {
    private int trailerCount;

    public SemiTruck(String color,
               int numberOfPassengers,
               int cargoCapacity,
               int fuelCapacity,
               int trailerCount) {

        super("Semi-Truck: ", color, numberOfPassengers, cargoCapacity, fuelCapacity);

        this.trailerCount = trailerCount;
    }
    public int getTrailerCount() {
        return trailerCount;
    }
    public void setTrailerCount(int trailerCount) {
        this.trailerCount = trailerCount;
    }
    public void honkHorn () {
        System.out.println("Honk Honk!");
    }
}

package workbook5.vehicle;

public class Hovercraft extends Vehicle{
    private boolean inflated;

    public Hovercraft(String color,
                      int numberOfPassengers,
                      int cargoCapacity,
                      int fuelCapacity,
                      boolean inflated) {

        super("Hovercraft",
                color,
                numberOfPassengers,
                cargoCapacity,
                fuelCapacity);
        this.inflated = inflated;
    }

    public boolean isInflated() {
        return inflated;
    }
    public void setInflated(boolean inflated) {
        this.inflated = inflated;
    }

    public void honkHorn () {
        System.out.println("Whee-Whee!");
    }
}
